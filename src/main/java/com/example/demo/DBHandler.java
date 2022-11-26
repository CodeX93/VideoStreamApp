package com.example.demo;

import javax.swing.text.View;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;

//import java.sql.*;

public class DBHandler {
	static Connection con=null;
	
	public DBHandler() {
		super();
		connectDB();
	}

	

	
	




	public static void connectDB() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SDAdb","root","");
			if(con == null) {
				System.out.println("DB connection failed");}
			else
				System.out.println("DB connection successful");

		}
		catch(Exception e) {
			System.out.println("exception: "+e);
		}
	}




	
	
	public static void deleteUserRecord(String ID) {
		try {
			String sql = "DELETE FROM Product WHERE category=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "crockery");
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			System.out.println("A user was deleted successfully!");
			}
		}catch(SQLException e) {
			System.out.println("Exception: "+e);
		}
	}
	
	public static void insertViewer(Viewer viewer) {
		try {
			String sql = "INSERT INTO Viewer(FirstName,LastName,Username,Email,Password) VALUES(?, ?, ?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, viewer.FirstName);
			statement.setString(2, viewer.LastName);
			statement.setString(3, viewer.Username);
			statement.setString(4, viewer.Email);
			statement.setString(5, viewer.Password);



			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new viewer was inserted in database successfully!");
			}
		}catch(SQLException e) {
			System.out.println("Exception: "+e);
		}
		
	}

	public static void insertViewers(ArrayList<Viewer> viwerList) {
		for(Viewer viewer: viwerList){
			insertViewer(viewer);
		}

	}

	public static ArrayList<Viewer> getAllViewers(){
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="select FirstName,LastName,Username,Email,Password from Viewer";
			ResultSet rs= stmt.executeQuery(sql);
			ArrayList<Viewer> viewers=new ArrayList<>();
			while(rs.next()) {
				viewers.add(new Viewer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			return viewers;
		}
		catch (Exception e) {
			System.out.println("exception: "+e);
		}
		return null;
	}

	public static boolean deleteAllViewers() {
		try {
			Statement st=con.createStatement();
			String sql="Delete from Viewer";
			int status=st.executeUpdate( sql);
			if(status==1)
				return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}


	public static ArrayList<Video> getAllVideos(){
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="select userEmail,videoName , videoDescription ,videoPath from Video";
			ResultSet rs= stmt.executeQuery(sql);
			ArrayList<Video> videos=new ArrayList<>();
			while(rs.next()) {
				//Viewer user,String videoName, String videoDescription, String videopath, File videoPath
				videos.add(new Video(Viewer.getViewer(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),new File(rs.getString(4))));
			}
			return videos;
		}
		catch (Exception e) {
			System.out.println("exception: "+e);
		}
		return null;
	}

	public static void insertVideos(ArrayList<Video> videoList) {
		for(Video video: videoList){
			insertVideo(video);
		}
	}
	public static void insertVideo(Video video) {
		try {

			String sql = "INSERT INTO Video(userEmail,videoName,videoDescription,videoPath) VALUES(?, ?, ?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, video.user.Email);
			statement.setString(2, video.videoName);
			statement.setString(3, video.videoDescription);
			statement.setString(4, video.videopath);



			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new Video was inserted in database successfully!");
			}
		}catch(SQLException e) {
			System.out.println("Exception: "+e);
		}

	}
	public static boolean deleteAllVideos() {
		try {
			Statement st=con.createStatement();
			String sql="Delete from Video";
			int status=st.executeUpdate( sql);
			if(status==1)
				return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static void insertFavouriteVideos(ArrayList<FavouriteVideo> favouriteVideos) {
		for(FavouriteVideo favouriteVideo: favouriteVideos){
			insertFavouriteVideo(favouriteVideo);
		}
	}

	public static void insertFavouriteVideo(FavouriteVideo favouriteVideo) {
		try {

			String sql = "INSERT INTO FavouriteVideo(videoPath,userEmail) VALUES(?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, favouriteVideo.favouriteVideo.videopath);
			statement.setString(2, favouriteVideo.favouriteVideo.user.Email);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new Favourite Video was inserted in database successfully!");
			}
		}catch(SQLException e) {
			System.out.println("Exception: "+e);
		}

	}


	public static ArrayList<FavouriteVideo> getAllFavouriteVideos(){
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="select videoPath,userEmail from FavouriteVideo";
			ResultSet rs= stmt.executeQuery(sql);
			ArrayList<FavouriteVideo> favouriteVideos=new ArrayList<>();
			while(rs.next()) {
				//Viewer user,String videoName, String videoDescription, String videopath, File videoPath
				Video tempVideo=Video.getVideo(rs.getString(1));
				Video video=new Video(Viewer.getViewer(rs.getString(2)),tempVideo.videoName,tempVideo.videoDescription,tempVideo.videopath,tempVideo.videoPath);
				//Viewer viewer= new Video(Viewer.getViewer(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4);
				favouriteVideos.add(new FavouriteVideo(video));
			}
			return favouriteVideos;
		}
		catch (Exception e) {
			System.out.println("exception: "+e);
		}
		return null;
	}


	public static boolean deleteAllFavouriteVideos() {
		try {
			Statement st=con.createStatement();
			String sql="Delete from FavouriteVideo";
			int status=st.executeUpdate( sql);
			if(status==1)
				return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}



	public static void insertRatings(ArrayList<Rating> ratingsList) {
		for(Rating rating: ratingsList){
			insertRating(rating);
		}
	}
	public static void insertRating(Rating rating) {
		try {
			String sql = "INSERT INTO Rating(rating,videoPath) VALUES(?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, rating.rating);
			statement.setString(2,rating.video.videopath);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new Rating was inserted in database successfully!");
			}
		}catch(SQLException e) {
			System.out.println("Exception: "+e);
		}

	}

	public static ArrayList<Rating> getAllRatings() {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="select rating,videoPath from Rating";
			ResultSet rs= stmt.executeQuery(sql);
			ArrayList<Rating> ratings=new ArrayList<>();
			while(rs.next()) {
				///rating varchar(100), videoPath varchar(100) NOT  NULL);
				//String rating, Video video
				ratings.add(new Rating(rs.getString(1),Video.getVideo(rs.getString(2))));
			}
			return ratings;
		}
		catch (Exception e) {
			System.out.println("exception: "+e);
		}
		return null;
	}


	public static boolean deleteAllRatings() {
		try {
			Statement st=con.createStatement();
			String sql="Delete from Rating";
			int status=st.executeUpdate( sql);
			if(status==1)
				return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}


	public static void insertComments(ArrayList<Comments> commentsArrayList) {
		for(Comments comment: commentsArrayList){
			insertComment(comment);
		}
	}
	public static void insertComment(Comments comment) {
		try {
			String sql = "INSERT INTO Comment(comment,videoPath) VALUES(?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, comment.comment);
			statement.setString(2,comment.video.videopath);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new Comment was inserted in database successfully!");
			}
		}catch(SQLException e) {
			System.out.println("Exception: "+e);
		}

	}

	public static ArrayList<Comments> getAllComments() {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="select comment,videoPath From Comment";
			ResultSet rs= stmt.executeQuery(sql);
			ArrayList<Comments> allComments=new ArrayList<>();
			while(rs.next()) {
				allComments.add(new Comments(rs.getString(1),Video.getVideo(rs.getString(2))));
			}
			return allComments;
		}
		catch (Exception e) {
			System.out.println("exception: "+e);
		}
		return null;
	}




	public static boolean deleteAllComments() {
		try {
			Statement st=con.createStatement();
			String sql="Delete from Comment";
			int status=st.executeUpdate( sql);
			if(status==1)
				return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	/*
	public static void saveUserRecord(User user) {
		try {
			String sql = "INSERT INTO User (ID,name,password) VALUES(?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, user.getAccount().getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getAccount().getPassword());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new User was inserted in database successfully!");
			}
		}catch(SQLException e) {
			System.out.println("Exception: "+e);
		}
		
	}
	*/

	public void readAllUsersRecord() {
		// TODO Auto-generated method stub
		
	}




/*	public static User fetchUserRecord(String ID, String password) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="Select ID,name,password from User where ID='"+ID+"' AND password='"+password+"'";
			ResultSet rs= stmt.executeQuery(sql);
			
			try {
				rs.next();
				User user=new User(rs.getString(1) ,rs.getString(2),rs.getString(3));
				return user;
			}catch(Exception e) {
				return null;
			}
			
		//con.close();
		}
		catch (SQLException e) {

			System.out.println("exception: "+e);
		}
		return null;
	}
	*/

	public static boolean deleteRecordFromFriendByFriendID(String friendID,String userID) {
		try {
			Statement st=con.createStatement();			
			String sql="Delete from Friend where userID='"+userID+"' AND friendID='"+friendID+"'";
			int status=st.executeUpdate( sql);			
			if(status==1)
				return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public static boolean deleteRecordFromFriendRequestByFriendID(String recieverID,String userID) {
		try {
			Statement st=con.createStatement();			
			String sql="Delete from FriendRequest where senderID='"+userID+"' AND recieverID='"+recieverID+"'";
			int status=st.executeUpdate( sql);			
			if(status==1)
				return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	/*
	public static ArrayList<User> fetchSentFriendRequestsFrom(String userID){
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="select recieverID from FriendRequest where senderID='"+userID+"'";
			ResultSet rs= stmt.executeQuery(sql);
			ArrayList<User> users=new ArrayList<>();
			while(rs.next()) {
				users.add(fetchUserRecord(rs.getString(1)));
			}
			return users;			
		}
		catch (Exception e) {
			System.out.println("exception: "+e);
		}
		
		
		return null;
	}
	*/
	

	

	public static boolean deleteComment(int CommentID) {
		try {
			Statement st=con.createStatement();			
			String sql="Delete from Comment where ID="+CommentID;
			int status=st.executeUpdate( sql);			
			if(status==1)
				return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Comment could not be deletd");
		return false;
	}
	
}
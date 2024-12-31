package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Showing Posts: ");
		System.out.println();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime time = LocalDateTime.parse("21/06/2018 13:05:44", format);
		
		Post post1 = new Post(time, "Traveling to New Zealand", "I'm going to visit this wonderful country!", 12);
		
		Comment c1 = new Comment("Have a nice trip");
		Comment c2 = new Comment("Wow that's awesome!");
		post1.addComment(c1);
		post1.addComment(c2);
		
		//---------------
		
		LocalDateTime time2 = LocalDateTime.parse("28/07/2018 23:14:19", format);
		
		Post post2 = new Post(time2, "Good night guys", "See you tomorrow", 5);
		
		Comment c3 = new Comment("Good night");
		Comment c4 = new Comment("May the Force be with you");
		
		post2.addComment(c3);
		post2.addComment(c4);
		
		System.out.println("\nPost 1: ");
		System.out.println(post1);
		
		System.out.println("\nPost 2: ");
		System.out.println(post2);
		
		sc.close();

	}

}

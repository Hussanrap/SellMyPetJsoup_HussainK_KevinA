/*
 * Problem 2 Sell My Pet Food
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetedAd {

  public static void main(String[] args)
  {
    /*  
     * TODO:
     * PREPARATION WORK
     * (1) Create a file called targetWords.txt. Populate this file with words on each line that
     *     you think would determine if a user is a dog or cat owner.
     * 
     * PROGRAMMING
     * (2) Create a new DataCollector object and set the data to "socialMediaPostsSmall.txt" and "targetWords.txt"
     *     Important: Use the socialMedialPostsSmall to create your algorithm. Using a small file will help you 
     *     generate your solution quicker and give you the ability to double check your work.
     * (3) Create a String variable to hold the names of all the user. (The first word of every post is 
     *     a person's username)
     * (4) Compare each user's post to each target word. If a user mentions a target word, add their username to 
     *     the String of users. Separate usernames with a space. 
     *         Hint: You can use loops to look through each word. 
     *         Hint2: You can use indexOf to check if a word is in a user post. 
     * (5) Once you have all the users, use your DataCollector's prepareAdvertisement method to prepare a file 
     *     with all users and the advertisement you will send them.
     *         Additional Info: The prepareAdvertisement creates a new file on your computer. Check the posts of
     *         some of the usernames to make sure your algorithm worked.
     * 
     * THE FINAL SOLUTION
     * (6) Your solution should work with the socialMedialPostsSmall.txt. Modify your DataCollector initialization
     *    so you use the socialMediaPosts.txt. You should now have a larger file of users to target.
     */


    /* your code here */
    // Declare a List to store the target words
    List<String> targetWords = new ArrayList<>();
    DataCollector collector = new DataCollector();
      // Load the target words from the "targetWords.txt" file
      try (Scanner targetScanner = new Scanner(new File("targetWords.txt"))) {
          while (targetScanner.hasNextLine()) {
              targetWords.add(targetScanner.nextLine().trim());
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace(); // Handle file not found exception
      }

      File postsFile = new File("socialMediaPostsSmall.txt");
      StringBuilder users = new StringBuilder(); // Using StringBuilder to efficiently append usernames

      try (Scanner scanner = new Scanner(postsFile)) {
          while (scanner.hasNextLine()) {
              String post = scanner.nextLine();
              String[] words = post.split(" ");
              String username = words[0];  // first word is the username

              // Check if any of the target words appear in the post
              for (String targetWord : targetWords) {
                  if (post.indexOf(targetWord) != -1) {  // Check if target word is in the post
                      if (users.indexOf(username) == -1) {  // Prevent duplicates
                          users.append(username).append(" ");
                      }
                      break;  // Exit loop after first match (no need to check further target words)
                  }
              }
          // After gathering all users, prepare the advertisement
          collector.prepareAdvertisement("socialMediaPostsSmall.txt", username, "Hello User");    
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace(); // Handle file not found exception
      }
      
     



  }

}

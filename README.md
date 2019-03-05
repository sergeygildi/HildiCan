<b></b>

<i>Hello, I present to your attention an application that performs when starting the function of the usual terminal command "ls" -
 displays on the screen, in a solid line, the entire contents of the directory. If the name or the path of another directory is passed as an argument, the program will display the contents of the specified directory.</i>
 
 If you want to use the application, let me tell you how to build and run it.
 
  Download the project and build it:

 
> `mvn clean package`

 
 Start app: 
 
 > `java -jar target/ls-1.jar`
  

 
  If you want to see what is in another directory, just specify the path to the desired directory as an argument.
 
 > `java -jar target/ls-1.jar /target`
  
  or
 
 > `java -jar target/ls-1.jar /src/main/java/`
 
or another if you want.
 
If you want to see hidden directories and files, add the  `"-a"` flag.
  
 > `java -jar target/ls-1.jar -a /src/main/java/`

So far this is all that the program does. 
 
Further more.
Thank you!

# Project design #

## Questions
1. Thinking of using a command line interface with the menus listed out.
2. Programmer's task is to implement addition and deletion of the CTA stops and add the functionality to expand it from just the red
   and green lines to all the lines.
3. Use the File object to read the data from the file and the scanner object to work with the data.
4. Data will be stored in the CTAStation object as an arraylist.
5. As has been done in labs 4, 5, 6
6. Changing the data would be done so as to maintain the order of the list. In other words, the list would still remain sorted.
7. I will search the data using binary search.
8. I will need the classes created in labs 4, 5, and 6 (namely, GeoLocation, CTAStation and CTARoute), apart from them, I'll be needing 
   the CTAApp class, which would actually be the one that implements the user interface, etc.
9. *Seperate file named "projectDesignUML.png*

10.The layout of the test plan would be as such:

	Test data      |    Expected Result    |     Actual result    |
	data1          |        2.0            |       2.0000231      |
	data2          |       "green"         |        "green"       |
	data3          |        true           |         true         |
  ...
  

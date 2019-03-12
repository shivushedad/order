# Follow these steps to run the code.
#### Step 1: Click "Clone or Download" then click "Download Zip".
#### Step 2: Extract the zip file in your local machine.
#### Step 3: Go to extracted folder on the command prompt.
#### Step 4: Build the application using below Maven Command.
    Example: c:\sortpizzaorder>mvn clean package <enter>
#### Step 5: Run the application:
    Example: c:\sortpizzaorder>java -jar target\SortPizzaOrders-0.0.1-SNAPSHOT.jar com.pizza.order.SortPizzaOrdersApp <input File> <output File> <enter>
        Note : Sample input file "sampleInput.txt" available in the root folder.
#### Step 6: Check the output file in the destination folder.

# To run the test cases:
#### Step 1. Make sure the application is built per the steps 1 - 4 above.
#### Step 2. Go to extracted folder on the command prompt
#### Step 3. Use below command to run the test suite:
    Example: c:\sortpizzaorder>mvn -Dtest=com.pizza.order.RunAllTests test
#### Step 4. check console output or target\surefire-reports directory for test reports.

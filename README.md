# Java-DesktopApp-BreakfastSale

Java Desktop Application Jose Luis Ramirez


![image](https://user-images.githubusercontent.com/72236278/94997966-38124a00-0574-11eb-9ce9-01e720fe8152.png)


This Project contains: *Java Project. *Connector JDBC. *Database in MySQL WorkBench - DB-Breakfast. *Document with Requirements for the creation of this Software.

-Purpose for this software: This Java Application has the objective, get the control for products (breakfast) for inventory and sales. Im attaching here document: "Specs.pdf" where i explain the entire problematic, requirements for this software and my solution with this Java app.

-This Java Project it's done with this next Models and Technologies: *Java SE: Java Standard Edition I'm using JDK14 wich is really stable in comparison with others new JDK.

*Java Swing Library: I use this library to be able to create components like buttons, text boxes, combo boxes, labels and manipulate images, all this components give to user a better experience and an easy one, because they dont need read to know how application works, its really interactive and simple at the same time.

*Free Images for icons in Frame: I am using images like icons and i'm giving some actions inside this program, this is for a better user experience. This images are completly free rigths, this is the page where you can find it: https://unsplash.com

*Connection with MySQL - WorkBench: In this application i'm using a database so i'm using MySQL connector and i'm stablising connection directly with MySQL. All the modifications i'm doing in this project are been saved in this Database, this is because i'm trying to be more efficient and comfortable for user, so i dont have to worry about loosing information at all.

Dedicated just one class to get the connection with mysql:

![Conexion MySQL](https://user-images.githubusercontent.com/72236278/94997710-8c1c2f00-0572-11eb-966a-33951f8eb63b.png)


*Relational Databases: I am using three different tables in this project the first one is to get the registry for food, in this case breakfast and all the characteristics for this one like, quantity, price, register, cathegory, and description. The second table is used to get the cathegory for breakfast and this one has a relation with first table, so if i delete just one cathegory because i'm not gonna use it anymore i'm also deleting all the breakfasts for this erased cathegory, not sales only breakfast register. The third table is used to get all the sales done for user, so i'm saving the breakfast name, sales quantity and payment by client all this information comunicates with first table (registry food) and do the appropiate update in quantities for product.


![Relational](https://user-images.githubusercontent.com/72236278/94997878-aefb1300-0573-11eb-862f-ce45d7fdab89.png)






















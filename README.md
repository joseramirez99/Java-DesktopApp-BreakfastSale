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


*CRUD: I am using Queries for MySQL like Create, Read, Update and Delete. All the actions for this project are based in this sentences, this sentences are able to insert registers in Database, update or modify registers, return registers (products, cathegories, sales) and delete each one of this. All this sentences are able to connect with Database and do all the changes that user needs anytime.


*Insert:
![image](https://user-images.githubusercontent.com/72236278/94999016-d9e96500-057b-11eb-94c5-f016940d3fd3.png)


*Update:
![image](https://user-images.githubusercontent.com/72236278/94999031-fb4a5100-057b-11eb-8121-c8dc24d0d161.png)


*Delete:
![image](https://user-images.githubusercontent.com/72236278/94999049-19b04c80-057c-11eb-8e91-ce2faf6482be.png)




*MVC(Model, View, Controller): One of the most important parts in the contruction for this project is the MVC Pattern, because this philosophy prettends divide all the project in three phases. 1.-Model: This one has the representation for all the data in the system, the business logical and the persistence. 2.-View: This one is the interface for user, it has comunications directly with user and receives all the requests, in this project the view was used only to hide icons or show icons in the frame, also i used a small method to protect the text boxes for posible wrong characters but all the logical and the controller code is not here in the view. This can bring us the posibility to replace really easy this components maybe for another ones or maybe just change the place for this components and we are not depending entirely for this ones. 3.-Controller: This one is working between model and view, managing all the information and transformations to adapt data for each one. In this part, the code that i'm using are built by methods assigned to buttons for insert, modify or delete in the entire application, all this code was used in communication with the model and view.


Here another example about the Model:

![image](https://user-images.githubusercontent.com/72236278/94998931-42841200-057b-11eb-8979-0fa0d647ceeb.png)


Separating about the controller, here i am able to get the results from the view and at same time i'm not coding into the view:
![carbon (4)](https://user-images.githubusercontent.com/72236278/94998677-4878f380-0579-11eb-8db7-1557d7adcb74.png)


The view is completly separated from the coding about the software, for example here i'm in the view section and i'm protecting the textfield from possible user errors
like introduce letters inside numbers, here the extract code:
![image](https://user-images.githubusercontent.com/72236278/94998891-f0db8780-057a-11eb-9eb6-29c9249f7247.png)















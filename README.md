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
![image](https://user-images.githubusercontent.com/72236278/94999240-c50dd100-057d-11eb-83b8-3332fcefdcf7.png)



*Relational Databases: I am using three different tables in this project the first one is to get the registry for food, in this case breakfast and all the characteristics for this one like, quantity, price, register, cathegory, and description. The second table is used to get the cathegory for breakfast and this one has a relation with first table, so if i delete just one cathegory because i'm not gonna use it anymore i'm also deleting all the breakfasts for this erased cathegory, not sales only breakfast register. The third table is used to get all the sales done for user, so i'm saving the breakfast name, sales quantity and payment by client all this information comunicates with first table (registry food) and do the appropiate update in quantities for product.


*CRUD: I am using Queries for MySQL like Create, Read, Update and Delete. All the actions for this project are based in this sentences, this sentences are able to insert registers in Database, update or modify registers, return registers (products, cathegories, sales) and delete each one of this. All this sentences are able to connect with Database and do all the changes that user needs anytime.


*Insert:

![image](https://user-images.githubusercontent.com/72236278/94999132-ede19680-057c-11eb-9b5b-61d43160e5bf.png)


*Update:

![image](https://user-images.githubusercontent.com/72236278/94999106-a529dd80-057c-11eb-96a2-d46a062fd9bb.png)


*Delete:

![image](https://user-images.githubusercontent.com/72236278/94999164-2da87e00-057d-11eb-93aa-0d31f65622d3.png)




*MVC(Model, View, Controller): One of the most important parts in the contruction for this project is the MVC Pattern, because this philosophy prettends divide all the project in three phases. 1.-Model: This one has the representation for all the data in the system, the business logical and the persistence. 2.-View: This one is the interface for user, it has comunications directly with user and receives all the requests, in this project the view was used only to hide icons or show icons in the frame, also i used a small method to protect the text boxes for posible wrong characters but all the logical and the controller code is not here in the view. This can bring us the posibility to replace really easy this components maybe for another ones or maybe just change the place for this components and we are not depending entirely for this ones. 3.-Controller: This one is working between model and view, managing all the information and transformations to adapt data for each one. In this part, the code that i'm using are built by methods assigned to buttons for insert, modify or delete in the entire application, all this code was used in communication with the model and view.


Here another example about the Model:

![image](https://user-images.githubusercontent.com/72236278/94998931-42841200-057b-11eb-8979-0fa0d647ceeb.png)


Separating about the controller, here i am able to get the results from the view and at same time i'm not coding into the view:

![image](https://user-images.githubusercontent.com/72236278/94999208-7e1fdb80-057d-11eb-95a3-d0c433e9c097.png)



The view is completly separated from the coding about the software, for example here i'm in the view section and i'm protecting the textfield from possible user errors
like introduce letters inside numbers, here the extract code:
![image](https://user-images.githubusercontent.com/72236278/94998891-f0db8780-057a-11eb-9eb6-29c9249f7247.png)




The Application Starts in this way:


![image](https://user-images.githubusercontent.com/72236278/95006552-6b33f800-05cb-11eb-9015-78b59a066ea9.png)

We can select any option in the Menu, but it is necessary register Category and Product so we can do the Sale...

Now I'm inside the Menu "Registro"

![image](https://user-images.githubusercontent.com/72236278/95006588-d4b40680-05cb-11eb-885e-d43cdc694c68.png)


We can select Categoria or Desayuno and do the registry for each one of this.

I'm inside "Categoria" in this moment so i am doing the registry for a new kind of breakfast:

![image](https://user-images.githubusercontent.com/72236278/95006627-2b214500-05cc-11eb-9761-902ac45b1124.png)


I'm done with the first Category in this moment:

![image](https://user-images.githubusercontent.com/72236278/95006656-5d32a700-05cc-11eb-9cfe-793218719a00.png)


So the app shows me the new profile created and it's ready to save another Category in the Database.

Here we are able to see the insertion for this new Category in MySQL WorkBench, so this first option is working perfectly...


![image](https://user-images.githubusercontent.com/72236278/95006697-94a15380-05cc-11eb-843d-b050d4f76a06.png)


![image](https://user-images.githubusercontent.com/72236278/95006710-c4e8f200-05cc-11eb-8a5f-b8944c834905.png)


In this moment i did a registry for breakfast and this is working good, i received a message telling me "Registro Insertado Correctamente" to let know about this last action.


![image](https://user-images.githubusercontent.com/72236278/95006740-fbbf0800-05cc-11eb-91d4-37add70808f8.png)

Breakfast saved on Database.

In this image i am showing the "Buscar" Menu, so in the same way i can take a look for a register in Category or a Breakfast...


![image](https://user-images.githubusercontent.com/72236278/95006759-417bd080-05cd-11eb-93a3-57a69d5db748.png)

Inside this last option i can find the breakfast or maybe not depending the register that i'm using it here, in this case i found the correct breakfast...


![image](https://user-images.githubusercontent.com/72236278/95006796-c36bf980-05cd-11eb-8969-d217862c225e.png)


Once i get the right register i am able to modify this same register or maybe just see all the attributes belonging on this plate


![image](https://user-images.githubusercontent.com/72236278/95006818-fb733c80-05cd-11eb-9c69-2820257564df.png)


In this only case i just changed the quantity for this product, imaging i did more of this in the business


![image](https://user-images.githubusercontent.com/72236278/95006839-2cec0800-05ce-11eb-924e-ca7c666c8cb6.png)



Here we are in the sales option, it is really simple and easy use this module... I starting lookgin for the breakfast availability, if i am able to sale at least one of this the program asks me for the payment and it has to be the rigth payment o more than expected but never less, if the payment its more the programm tell me how much money i have to return to this client...


![image](https://user-images.githubusercontent.com/72236278/95006860-83f1dd00-05ce-11eb-84f8-be5183f086f6.png)



Program asking for quantity:

![image](https://user-images.githubusercontent.com/72236278/95006880-b56aa880-05ce-11eb-9a53-154152a91dba.png)


Wrong payment, program does not execute the sale...

![image](https://user-images.githubusercontent.com/72236278/95006893-ddf2a280-05ce-11eb-9461-2d9b4fbf7e7e.png)


Correct payment, program tell user how much money needs to return to client...

![image](https://user-images.githubusercontent.com/72236278/95006944-7557f580-05cf-11eb-958b-abb74590b820.png)


Database in MySQL Workbench, we can see the table Ventas and we have registered this last sale we did...

![image](https://user-images.githubusercontent.com/72236278/95007009-1ba3fb00-05d0-11eb-874a-20283963061f.png)









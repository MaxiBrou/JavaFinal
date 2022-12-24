# JavaFinal

The Model Explorer
A web page used to add models, and explore the different models that are available in your area. Very usefull for photographs!

Description:
This model exlorere is used to see models for photography. We are able to add models and remove models. 
It includes the first name, the last name, the instagram and the email address. It also includes the address (street, city and postal code)
There is also some option for website customisation where you can change the background color using the presets or using the special color picker.
There is also a reset button to put the background white again.
For the models, there is a heart-shaped button so you can like models and make them easier to find, if you have a long list of models.
I had some challenge linking the react app with the database.
In the future, i hope i can implement a sorting system and maybe a way for the heart-shapped button to save the profile of the models somewhere.
I also want to add a way to add pictures, so you don't just have the name of the models.

Design:
There is a class for the heart-shaped button, there is a class for the text to display when a new model is created, which also hold the delete function. And there is the Models class that holds all the logice for the code
There is a table for the Models which is linked to address with a One-To-One relationship. There is also a one to many relationship with availabilities.


# GhibliHub

## Description
A web application that provides a platform for Ghibli fans to share their interests, rate the films, and post reviews and comments.

## Technologies Used
### Front-End:
- HTML5
- Thymeleaf
- CSS
- JavaScript


### Back-End:
- Java 8
- Spring 5
- Spring Security
- PostgreSQL
- Apache Maven
- JUnit
- Mockito

### Other Technologies:
- AWS Elastic Beanstalk
- AWS CodeBuild
- AWS CodePipeline
- AWS RDS
- DBeaver
- Postman
- Git

### External API: https://ghibliapi.herokuapp.com/films

## Features
- A user can create and login to accounts
- Users can view all films (leveraged from an external API)
- Users can rate a film (1-5 ⭐) and write a review
- Users can comment on other users reviews

### To-Do
- Create an Admin role for user accounts that has delete privileges for accounts, reviews, and comments
- Users can create a checklist for the films they have seen already
- Users can favorite top 3 films they have seen

## Getting Started
1. To start off, please git clone the project: https://github.com/210726-Enterprise/JDBC_p2.git
2. Create a database and schema
3. In the application.properties file, input the url, username, and password for your database
![unknown](https://user-images.githubusercontent.com/88043821/133683677-852a5995-f589-4059-8811-dc37acf2dbc4.png)
4. In application properties change the _spring.jpa.hibernate.dll-auto=update_ to _spring.jpa.hibernate.dll-auto=create_
![update create](https://user-images.githubusercontent.com/88043821/133684627-f605c8c2-f2ec-4b19-9acc-3644e989a173.png)
5. Populate tables in your database by uncommenting and calling this Post method in GhibliFilmController
![populate tables](https://user-images.githubusercontent.com/88043821/133684342-73fe4b01-b157-4a09-85fd-cadb510c6047.png)
6. Revert the change in step 4 back to update once the tables have been persisted in your database
7. Run server and the application should be running in your _localhost:8080/Ghiblihub_
![welcome_screen](https://user-images.githubusercontent.com/88043821/133685492-94a17851-3f0e-4f55-8ce2-dbeab7f1cc7d.png)

## Usage
1. Upon clicking **'Enter'**, user should be greeted with the film list page as shown below:
![film_list](https://user-images.githubusercontent.com/88043821/133685792-8b0bad42-896b-4abb-b52f-c9f13fa44fdc.png)
2. Click **'More'** on any film to be prompted to the login page if user has not logged in yet:
![clicking more](https://user-images.githubusercontent.com/88043821/133685982-6d5e2149-96f6-439f-9f5d-e03376f13ef0.png)
![login](https://user-images.githubusercontent.com/88043821/133686063-1217591a-ee87-4b58-921a-7c47b042167b.png)
3. If an account has not been persisted in the database, users must go to the register user page and create an account:
![registration](https://user-images.githubusercontent.com/88043821/133686288-295886f4-45ab-431f-9843-5ceacb577173.png)
4. Afterwards, users will be able to go to any film details and rate + write a review on the film:
![review](https://user-images.githubusercontent.com/88043821/133686443-05ea73c9-45a2-449b-b0f2-4de07192add7.png)
5. Once a review has been created, users can click comment on the side of the review and create a comment on the selected review:
![comment](https://user-images.githubusercontent.com/88043821/133686616-bf7896a4-04c4-49cc-9cf4-63c0d004e229.png)

## Contributors
- Jintao Lin
- Christopher Zhang
- Douglas Ramirez

## Disclaimer
All Ghibli Film assets used were taken under fair use, if any content violates copyright law please contact us and we will remove ASAP.

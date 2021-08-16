# Tuition Reimbursement Management System (TRMS)

## Project Description

This is a tuition reimbursement management system to where a user can login and enter a tuition reimbursement form to summit to thier job for reimbursment of funds after being approved by a direct supervisor, a department head, and a benefits coordinator while the employee is able to track the status of their requests. A direct supervisor, a department head, and a benefits coordinator are then able to login and select an employee to be approved or denied with a denial reason and the option to submit addional information. Approvals must be completed in the order of authority of management. Once an approval is completed by all levels of management the amount of the request is processed with a comparison of the allotted yearly yearly funding and adjusted by a percentage of how much is covered by the type of training requested.

## Technologies Used

* Java
* Hibernate
* Javalin
* Maven
* jUnit4
* Selenium
* Postman
* Javascript
* HTML/CSS

## Features

List of features ready and TODOs for future development
* Login for a direct supervisors, a department head, benefits coordinator, and employees
* Tuition reimbusment form submit
* Pending and completed requests page with grade submission
* Employee cancellation feature
* Contact information update page with login update
* Management employee request selector with approval/denial and reason for denial as well as additional information
 

To-do list:
* A proper registration page
* Links in nav bar should change by user logged in
* an email system to notify the programs users of progressions in reimbursment 

## Usage

* Import application into IDE that can handle Maven projects
* The user must start by adding database credentials to the hibernate.cfg.xml file
* Run app.java to start the project and to create and populate the database
* Run login.html to start the site locally
* Login from a user listed in the database
* Fill out a request 
* View request in pending requests
* Login as direct superviser and approve or deny
* Login as department head and approve or deny
* Login as benifits coordinator and approve or deny
* Login in as employee and view completed results
* Alternatively you can run the seleniumtest file in apps to run through this with automation

## Contributors

This was a solo project by Stuart Kruze

## License

This project uses the following license: LICENSE.md https://github.com/stukruze/Revature-Projects/blob/main/LICENSE

# SimplyPeopleWebsite

## HR Personnel Management Software for “Simply People”
### ACTOR LIST

1.	__Project manager:__ Incharge of project assignment and delivery.
2.	__HR manager:__ Person responsible for managing the personals inside the organization and address issues they have.
3.	__Employee:__ Person who undergoes training and works for the project delivery.

### ACTOR GOAL LIST WITH PRIORITY

__HR Manager (Admin)__
1.	Add, deletes, and updates the employee information. 
2.	Handles both hiring actions and resignations. 
3.	Listens to employee grievances and act upon them.

__Project Manager__
1.	Coordinates with HR manager in employee On-boarding and Off-boarding process.
2.	Schedules training based on HR manager’s approval. 
3.	Manages the employee release from the project. 
4.	Review employee performance and manage appraisals. 
5.	Allocates training to employees 
6.	Listens to employee grievances and act upon them.

__Employee__ 
1.	Registers trainings.
2.	Gives his personal details
3.	Registers complaints. 
4.	Requests for project release and notify resignations.


### FULLY DRESSED USE CASES

__Use case Name: Hiring New Employees__

__Use case level:__ User Goal

__Primary Actor:__ HR Manager 

__Pre-condition:__ Gather Employee information about Interview process

__Success Guarantee:__ Makes offer to suitable candidates. 

__Main Success Story:__ 

1.	HR logins to his account
2.	Opens the dashboard for hiring new employees 
3.	Looks upon all the applications available on his hiring dashboard.
4.	Gets available applications suitable for hiring 
5.	Screens the candidates based on the scores and makes offers
6.	HR receives acceptance confirmation from the selected candidates
7.	Updates the details about selected candidates in the system
8.	Candidates join the organization on the planned joining date

__Extensions:__ 

1.	If login attempt fails it gives an alert as invalid username/password.  
2.   If offer is declined then HR will remove details about employees from database.
3.   If the selected candidate is not present on the date of joining then the offer is most likely to be declined.

__Use case Name: Employee directory__

__Use case level:__ User Goal

__Primary Actor:__ HR Manager

__Pre-condition:__ Valid employee information entered in the system

__Success Guarantee:__ Maintain and update employee information within the organization

__Main success story:__

1.	HR logins to his account
2.	Opens Employee Directory dashboard
3.	Adds, Deletes, Edits, Search and Updates the Employee details 
4.	Categorizes employees based on skill set and experience
5.	Both professional and personal information of employees will be maintained
6.	Uses the directory to allocate resources to the project
7.	Tracks employee history based on this information in the database
8.	Updates the title and the level whenever necessary

__Extensions:__

1.	Incorrect information gives an alert to correct the information    
2.	HR Manager removes employee information once the employee quits the company

__Use case Name: Allocating employee to PM__

__Use case level:__ User Goal

__Primary Actor:__ HR Manager

__Pre-condition:__ Identify the skill sets and employee experience that the project demands

__Success Guarantee:__ Assign the suitable employees to the project

__Main success story:__

1.	HR Manager logins to his account
2.	HR Manager receives the request from project manager about the resources required for the project
3.	HR Manager searches for suitable resources in the directory who have completed all the prerequisites
4.	HR Manager checks for the currently available resources from the Employee directory
5.	HR Manager checks if the available candidates match the skill sets and the experience that the project demanded.
6.	HR Manager screens the candidates based on the project requirements and allocates the suitable resource

__Extensions:__

1)	If trainings are not available at the moment then Project Manager sets up new trainings that employees are already familiar with.
2)	If no suitable resources in the directory then hire new candidates
3)	If all the prerequisites required for project are not fulfilled then looks for other suitable employee

__Use case Name: On-boarding and Off-boarding process__

__Use case level:__ Project Manager Goal

__Primary Actors:__ Project Manager

__Pre-condition:__ Resource allocation to Project Manager

__Success Guarantee:__ Providing necessary information to new resources joining the team and releasing the existing resources from the team

__Main success story:__

1.	Project Manager login
2.	Checks the prerequisites if available or not
3.	Assigns project to the employees 
4.	Provides background information about the project to new resources
5.	New Employees will be introduced to clients and other team members
6.	Providing necessary resources such as desktop, monitor and other electronic gadgets that are pivotal to the job
7.	Providing relevant documentation about the project to Employee
8.	Releasing current resources from the project after all the tasks are done by the employee

__Extensions:__

1.	Project Manager requesting for alternate resources before releasing the current employee
2.	Knowledge transfer should be carried out by the relieving resource to the new resource
3.	Existing resources will not be released from the project if there is no alternate resource available
4.	The employee will continue to work with the project if there is no replacement available 

__Use case Name: Training Management__

__Use case level:__ Project Manager Goal

__Primary Actor:__ Project Manager

__Pre-condition:__ Gather information about the technical gaps that employees have related to the project

__Success Guarantee:__ Allocating suitable training to employees based on the project needs 

__Main success story:__

1.	Project Manager login
2.	Searches for the currently available technical training in the organization
3.	Identifies the gaps that the employee has with regards to the project
4.	Allocates schedule for the Employee to undergo the training process
5.	Allocates training to employees based on the identified skill gaps
6.	The employee will have to undergo assigned training and complete the training process

__Extensions:__
1.	Project Manager will release the employee from the team if the employee did not complete the training process
2.	Project Manager will allocate projects to employees once the training process is complete
3.	Project Manager will request for alternate resources if the employee did not clear the training process
4.	Project Manager may allocate additional training to Employee 

__Use case Name: Listens to employee grievances__

__Use case level:__ Project Manager Goal

__Primary Actors:__ Project Manager

__Pre-condition:__ Employee registering complaints in the portal to Project Manager

__Success Guarantee:__ Project Manager acknowledging the complaints and look into the complaints

__Main success story:__

1.	Project Manager login
2.	Employees registering complaints regarding the project, allowances and any other issues in the portal to Project Manager
3.	Project Manager determines the level of urgency in dealing with the situation
4.	He then investigates the complaints by gathering the facts related to the complaints
5.	Discusses with the Employee regarding the problem posted
6.	Project Manager comes to a conclusion after the investigation

__Extensions:__

1.	Providing inadequate appraisals citing company performance and profits
2.	Managers considering clients feedback for providing allowances
3.	Employees unsatisfied with the response from Project Manager and escalating the issue to HR Manager
4.	HR Manager receives the complaint and gathers information about the previous actions taken
5.	HR Manager discusses individually with both Employee and Project Manager regarding the issue
6.	HR Manager makes the final decision on the issue and informs the Project Manager and Employee

__Use case Name: Registers training details__

__Use case level:__ User Goal

__Primary Actor:__ Employee

__Pre-condition:__ Project Manager suggests the training for the employees to undergo

__Success Guarantee:__ Employees attends the training and complete the training process

__Main success story:__

1.	Employee Login
2.	Project Manager recommends suitable training to Employees
3.	Employee searches for the training offered in the organization
4.	Employee checks for the available training in the portal
5.	Employee books the training based on his schedule
6.	Employee completing the training process and updating the Project Manager

__Extensions:__

1.	Employee takes the test to complete the training process
2.	An Employee is given up to 3 chances to complete the training process by clearing the exams.
3.	Employee completes the training modules on time
4.	Employees cannot register for training without Project Managers approval the next time

__Use case Name: Registers complaint__

__Use case level:__ User Goal

__Primary Actor:__ Employee

__Pre-condition:__ Employees facing any kinds of issues in the organization

__Success Guarantee:__ Employees providing a detailed description of the issues in the portal

__Main success story:__

1.	Employee Login
2.	The employee provides information about the issues that they face in the organization
3.	The employee should have the ability to attach any email references as evidence
4.	Project Manager receives the complaints in his portal and acknowledges the complaints
5.	Project Manager sets up a meeting with all concerned parties
6.	HR Manager addressing the escalation put forward by the Employee

__Extensions:__

1.	Employee should have the ability to withdraw complaints from the portal
2.	Employee acknowledging the actions taken by either Project Manager or HR Manager
3.	Employees not satisfied with the Project Manager’s actions and escalating the issue to HR Manager

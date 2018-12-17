Feature:Testing demo

  #@tag1
  #Scenario: search in google
    #Given Open "chrome" browser and launch "url"
    #And enter the "searchValue" as "weather chennai"to search
    #And click "submit" button
    #When click on "searchWord"
    #Then I validate the outcomes
    

 @tag2
 Scenario:Orange application -change of employee id
 Given Open "chrome" browser and launch "url"
 And enter "txtUsername" username as "Admin"
 And enter "txtPassword" password as "admin123"
 And click on "btnLogin" submit button
 When click on "menu_pim_viewPimModule" submit button
 Then enter "empsearch_id" as "1001" 
	And click on "searchBtn" submit button
	And click on "1001id" button
	Then verify "personal_txtEmployeeId" is readonly
	And click on "btnSave" submit button
	Then enter "personal_txtEmployeeId" as "0003"
	And click on "btnSave" submit button
	Then close browser
 
 #@tag3
 #Scenario:Orange application - adding new employee data
 #Given Open "chrome" browser and launch "url"
 #And enter "txtUsername" username as "Admin"
 #And enter "txtPassword" password as "admin123"
 #And click on "btnLogin" submit button
 #When click on "menu_admin_viewAdminModule" submit button
 #	And click on "btnAdd" submit button
 #	Then enter "systemUser_employeeName_empName" as "john smith"
 #	 	Then enter "systemUser_userName" as "john05"
 #	And click on "btnSave" submit button
 #	Then close browser
 	
#	@tag4
#	Scenario:Orange application -retrieval of id
 #Given Open "chrome" browser and launch "url"
 #And enter "txtUsername" username as "Admin"
 #And enter "txtPassword" password as "admin123"
 #And click on "btnLogin" submit button
 #When click on "menu_pim_viewPimModule" submit button
 #Then display all "tableId" datas
 #Then close browser
 
 #@tag5
 #Scenario:Orange application -search leaves as per date and uncheck pending approvals
 #Given Open "chrome" browser and launch "url"
 #And enter "txtUsername" username as "Admin"
 #And enter "txtPassword" password as "admin123"
 #And click on "btnLogin" submit button
 #When click on "menu_leave_viewLeaveModule" submit button
 #Then select "calFromDate" and "calToDate" dates
 #And click on "btnSearch" submit button
 #And uncheck "pendingApproval" check box
 #Then close browser
 
 @tag6
Scenario:Orange application -verify records
 Given Open "chrome" browser and launch "url"
 And enter "txtUsername" username as "Admin"
 And enter "txtPassword" password as "admin123"
 And click on "btnLogin" submit button
 Then click on "menu_recruitment_viewRecruitmentModule" submit button
 And enter "candidateSearch_candidateName" as "mouni maraka"
 And click on "btnSrch" submit button
 And display all "tableId" datas
 And verify "mouni maraka" in "tableId" candidate name
Then close browser
  
  @tag7
 Scenario:Orange application -login unsuccessful
  Given Open "chrome" browser and launch "url"
 And enter "txtUsername" username as "Admin"
 And enter "txtPassword" password as "admin12"
 And click on "btnLogin" submit button 
 Then verify "spanMessage" error message
 
 #@tag8
  #Scenario:Orange application -Delete user
  #Given Open "chrome" browser and launch "url"
 #And enter "txtUsername" username as "Admin"
 #And enter "txtPassword" password as "admin123"
 #And click on "btnLogin" submit button
 #Then click on "menu_admin_viewAdminModule" submit button
 #And click on "ohrmList_chkSelectRecord_6" submit button
 #And click on "btnDelete" submit button
 #And click on "dialogDeleteBtn" submit button
 
 #@tag9
 #Scenario:Orange application -Delete user
  #Given Open "chrome" browser and launch "url"
 #And enter "txtUsername" username as "Admin"
 #And enter "txtPassword" password as "admin123"
 #And click on "btnLogin" submit button
 #
  
 
 
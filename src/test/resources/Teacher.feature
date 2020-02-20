Feature: Teacher Experience
	Background: On Home Page
		Given The teacher is on the Home Page
		
		Scenario: Log in
			When the teacher logs in with their credentials
			Then the teacher is on the teacher page
			
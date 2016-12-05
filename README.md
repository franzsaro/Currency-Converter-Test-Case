# Currency-Converter-Test-Case
Contents
I.	Introduction		
II.	Resources		
III.	The implementation	
	    The approach			
	    Description of the test case	

 
I.	Introduction

SQS has requested me (by means of E-Frontiers) to create in Java using Junit an Acceptance test case for the website http://www.xe.com/currencyconverter/

Task:
•	Write an acceptance test for http://www.xe.com/currencyconverter/
•	The test should iterate over 5 sets of sample data.
•	Put in a conversion rate from Euro to pounds.
•	Verify the result on the proceeding page.

The solution should consist of;
•	Running the test from the maven build tool.
•	Reports to be pointed out where generated in a readme file included in the project.
•	Unit framework junit or testNG can be used.
•	Assertions should be used for verification.



 
II.	Resources

The program has been developed using Eclipse Java EE IDE for Web Developers version Neon.1a Release (4.6.1) and Selenium WebDriver Language Binding 3.0.1 for Java on windows 8.1. 




 
III.	The implementation

The approach

There is only 1 test case:
•	VerifyConversion()

Description of the test case

It access the website and the it performs 5 different validations (using assert as requested) on 5 different element from the main website
It tries then to get the conversion from EUR into POUND. The output of this conversion has been “hardcoded” and it is always passing. As it is commented in the code the second parameter should be customized by using the real Pound rate got from an external source at the time that the test case is executed.

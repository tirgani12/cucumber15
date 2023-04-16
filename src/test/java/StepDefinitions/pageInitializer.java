package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.LoginPage;

public class pageInitializer {
    public  static LoginPage login;
    public  static AddEmployeePage addEmployeePage;
    public  static void initializePageObjects()
    {
        login = new LoginPage();
        addEmployeePage= new AddEmployeePage();
    }



    }


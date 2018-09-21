using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Homework2
{
    public partial class ExpenseReportHome : System.Web.UI.Page
    {
        //If this is the first first time to load the page, 
        //then insert values into the ddl
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                //populates the drop down menu with the different types of expenses
                String[] typeofExpense = { "Mileage", "Meals", "Hotel", "Other"};
                for (int i = 0; i <= 3; i = i + 1)
                {
                    ddlExpenseType.Items.Add(typeofExpense[i]);
                }
            }
            //Checks to make sure the date they entered is not past the current date
            DateValidator.MaximumValue = DateTime.Now.ToShortDateString();

            
        }
        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            //Displays all the info in the text box in the ERlabel
            ERlabel.Text = ddlExpenseType.SelectedValue + ", " + DateofExpenseText.Text + ", " + ExpenseAmountText.Text;
        }
        protected void btnClear_Click(object sender, EventArgs e)
        {
            //Clears all info in tables and label
            ddlExpenseType.SelectedIndex = 0;
            DateofExpenseText.Text = "";
            ExpenseAmountText.Text = "";
            ExpenseDiscriptionText.Text = "";
            ERlabel.Text = "";
        }

    }
   
}
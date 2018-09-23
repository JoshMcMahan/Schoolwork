using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PriceQuote
{

    public partial class PriceQuotation : System.Web.UI.Page
    {
        
        // when the button is clicked find the discount price and display the new price and ammount of the discount to the lables
        // in currancy form
        protected void btnCalculate_Click(object sender, EventArgs e)
        {
            double userSalePrice = Convert.ToDouble(tbSalesPrice.Text);
            double userDiscountPrice = Convert.ToDouble(tbDiscountPrecent.Text);
            double finaleTotal = 0.0;
            
            userDiscountPrice = (userDiscountPrice / 100) * userSalePrice;
            finaleTotal = userSalePrice - userDiscountPrice;

            lbDiscountAmount.Text = userDiscountPrice.ToString("C");
            lbTotalPrice.Text = finaleTotal.ToString("C");
            
        }
    }
}



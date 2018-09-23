<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PriceQuotation.aspx.cs" Inherits="PriceQuote.PriceQuotation" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Price Quotation</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="scripts/jquery-3.3.1.min.js"></script>
    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <link href="Content/PriceQuote.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
        <div class="container">
            <h1 class="jumbotron">Price Quotation</h1>
            <div class="form-group row">
                <!-- creates the text boxes, lables and their validators for this div tag-->
                <label class="col-sm-3 col-form-label lbFontWeight">Sales Price:</label>
                <asp:TextBox CssClass="col-sm-3 form-control" ID="tbSalesPrice" runat="server" TextMode="Number"></asp:TextBox>
                <div class="col-6 alignValidator text-danger">
                    <asp:RequiredFieldValidator ID="PriceRequiredValidator" runat="server" ControlToValidate="tbSalesPrice" ErrorMessage="Please enter a sales price " Display="Dynamic"></asp:RequiredFieldValidator>
                    <asp:RangeValidator ID="PriceRangeValidator" runat="server" ControlToValidate="tbSalesPrice" ErrorMessage="Price must be between 100 and 2500" MaximumValue="2500" MinimumValue="100" Display="Dynamic" Type="Double"></asp:RangeValidator>
                </div>
            </div>
            <div class="form-group row">
                <!-- creates the text boxes, lables and their validators for this div tag-->
                <label class="col-sm-3 col-form-label lbFontWeight">Discount Price:</label>
                <asp:TextBox CssClass="col-sm-3 form-control" ID="tbDiscountPrecent" runat="server" TextMode="Number"></asp:TextBox>
                <div class="col-6 alignValidator text-danger">
                    <asp:RequiredFieldValidator ID="RequiredDiscountValidator" runat="server" ControlToValidate="tbDiscountPrecent" ErrorMessage="Please enter a discount " Display="Dynamic"></asp:RequiredFieldValidator>
                    <asp:RangeValidator ID="DiscountRangeValidator" runat="server" ControlToValidate="tbDiscountPrecent" ErrorMessage="Discount must be between 5 and 75" MaximumValue="75" MinimumValue="5" Display="Dynamic" Type="Double"></asp:RangeValidator>
                </div>
            </div>
            <div class="form-group row">
                <!-- Creates the lable that go under the text boxes setting them to $0-->
                <label class="col-sm-3 col-form-lable lbFontWeight">Discount Amount:</label>
                <asp:Label ID="lbDiscountAmount" runat="server" Text="$0"></asp:Label>
            </div>
            <div class="form-group row">
                <!-- Creates the lable that go under the text boxes setting them to $0-->
                <label class="col-sm-3 col-form-lable lbFontWeight">Total Price:</label>
                <asp:Label ID="lbTotalPrice" runat="server" Text="$0"></asp:Label>
            </div>
            <div class="form-group">
                <!-- creates the button with the on click feature-->
                <asp:Button ID="btnCalculate" CssClass="btn-primary btn offset-sm-3" runat="server" Text="Calculate" OnClick="btnCalculate_Click" />
            </div>
        </div>
    </form>
</body>
</html>

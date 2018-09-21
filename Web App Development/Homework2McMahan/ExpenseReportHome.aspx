<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ExpenseReportHome.aspx.cs" Inherits="Homework2.ExpenseReportHome" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <!-- link to import jquery and my css file -->
&nbsp;<link href="Content/myCSS.css" rel="stylesheet" /><script src="Scripts/jquery-3.3.1.min.js"></script></head><body style="height: 341px"><form id="form1" runat="server">
    <!-- heading for the table -->
    <h1>Expense Reporting</h1>
        <table class="auto-style1">
            <tr>
                <td class="auto-style2">Expense Type </td>
                <td class="auto-style3">
                    <asp:DropDownList ID="ddlExpenseType" runat="server">
                    </asp:DropDownList>
                </td>
            </tr>
            <tr>
                <!-- Added all the text boxes, validators, requiered fields, and buttons for the table -->
                <td class="auto-style2">Date of Expense</td>
                <td class="auto-style3">
                    <asp:TextBox ID="DateofExpenseText" runat="server"></asp:TextBox>
                </td>
                <td>
                    <asp:RequiredFieldValidator ID="DateRequieredField" runat="server" ControlToValidate="DateofExpenseText" ErrorMessage="Please enter the date of your expense. " ForeColor="Red"></asp:RequiredFieldValidator>
                    <asp:RangeValidator ID="DateValidator" runat="server" ControlToValidate="DateofExpenseText" ErrorMessage="Please enter a date before 1/1/18 and todays date" ForeColor="Red" MinimumValue="1/1/18" Type="Date"></asp:RangeValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">Expense Discription
                </td>
                <td class="auto-style3">
                    <asp:TextBox ID="ExpenseDiscriptionText" runat="server"></asp:TextBox>
                </td>
                <td>
                    <asp:RequiredFieldValidator ID="DescriptionRequieredField" runat="server" ControlToValidate="ExpenseDiscriptionText" ErrorMessage="Please enter a description of your expense. " ForeColor="Red"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">Expense Amount</td>
                <td class="auto-style3">
                    <asp:TextBox ID="ExpenseAmountText" runat="server"></asp:TextBox>
                </td>
                <td>
                    <asp:RequiredFieldValidator ID="AmountRequieredField" runat="server" ControlToValidate="ExpenseAmountText" ErrorMessage="Please enter the amount of your expense. " ForeColor="Red"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">SUMMARY</td>
                <td class="auto-style3">
                    <asp:Label ID="ERlabel" runat="server"></asp:Label>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style2">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style2">
                    <asp:Button OnClick="btnSubmit_Click" ID="btnSubmit" runat="server" Text="Submit"/>
                </td>
                <td class="auto-style3">
                    <asp:Button OnClick="btnClear_Click" ID="btnClear" runat="server" Text="Clear"  />
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style2">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    
    
    </form>
</body>
</html>

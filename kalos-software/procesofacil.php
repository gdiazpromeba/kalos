<html>
  <body>
<!--
<form target="paypal" action="https://www.paypal.com/cgi-bin/webscr" method="post">
-->
<form target="paypal" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">

<form action="https://www.paypal.com/cgi-bin/webscr" method="post">
<input type="hidden" name="cmd" value="_cart">
<input type="hidden" name="upload" value="1">
<input type="hidden" name="business" value="seller@designerfotos.com">
<input type="hidden" name="item_name_1" value="Item Name 1">
<input type="hidden" name="amount_1" value="1.00">
<input type="hidden" name="item_name_2" value="Item Name 2">
<input type="hidden" name="amount_2" value="2.00">
<input type="submit"" value="PayPal">
</form>

</body>
</html>

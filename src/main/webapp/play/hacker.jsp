<html >
<head>
<%@include file="./head.jsp"%>
<style>
  html, body {margin:0; padding:0; background-color:#000;}
  #divList {width:100%; height:100%; 
  /* border:solid 3px gray; */ 
  margin: 0px auto; overflow:hidden; position: relative;}
  .divText {position: absolute;}
  .divText span {display:block; font-weight: bold; font-family:Courier New; }
  </style>
</head>

<body>
 <div id="divList">
 </div>
 <script>
 function rand(min, max)
 {
  return min + Math.round(Math.random() * (max - min));
 }
 function add()
 {
  var x = rand(0, document.body.clientWidth);
  var html = '<div class="divText" style="left:' + x + 'px; bottom:100%;">';
  /*
  var color1 = [];
  var color2 = [];
  var color3 = [];
  var color4 = [];
  var color5 = [];
  var color6 = [];
  for (var i=1; i<17; i++)
  {
   var f = i.toString(16);
   color1.push('0' + f + '0');
   color2.push(f + '00');
   color3.push('00' + f);
   color4.push('0' + f + f);
   color5.push(f + f + '0');
   color6.push(f + '0' + f);
  }
  var color = [color1, color2, color3, color4, color5, color6];
  var ci = rand(0, 5);
  */
  var color = [];
  for (var i=1; i<21; i++)
  {
   var f = i.toString(16);
   color.push('0' + f + '0');
  }
  var fontSize = rand(8, 24);
  for (var i=1; i<10; i++)
  {
   var c = rand(33, 127);
   var c = String.fromCharCode(c);
   // html += '<span class="s' + i + '" style="color:#' + color[ci][i-1] + '; font-size:' + fontSize + 'px;">' + c + '</span>';
   html += '<span class="s' + i + '" style="color:#' + color[i-1] + '; font-size:' + fontSize + 'px; text-shadow:0px 0px 10px #' + color[i-1] + ';">' + c + '</span>';
  }
  html += '</div>';
  $('#divList').append(html);
 }
 function run()
 {
  var x = rand(0, 100);
  if (x < 100)
  {
   add();
  }
  $('#spanCount').html($('.divText').size());
  $('.divText').each(function(){
   var y = $(this).css('bottom');
   y = parseInt(y);
   y -= $(this).find('span').eq(0).height();
   $(this).css('bottom', '' + y + 'px');
   if (y + $(this).height() <= 0)
   {
    $(this).remove();
    return;
   }
   $(this).find('span').each(function(){
    var c = rand(33, 127);
    var c = String.fromCharCode(c);
    $(this).html(c);
   });
  });
  window.setTimeout(run, 55);
 }
 run();
 </script>

</body>

</html>
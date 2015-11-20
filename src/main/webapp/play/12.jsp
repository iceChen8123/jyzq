<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@include file="./head.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="plane/main.css"/>
</head>

<body>
<div id="contentdiv">
    <div id="startdiv">
        <button onclick="begin()">开始游戏</button>
    </div>
    <div id="maindiv">
        <div id="scorediv">
            <label>分数：</label>
            <label id="label">0</label>
        </div>
        <div id="suspenddiv">
            <button>继续</button><br/>
            <button>重新开始</button><br/>
            <button>回到主页</button>
        </div>
        <div id="enddiv">
            <p class="plantext">飞机大战分数</p>
            <p id="planscore">0</p>
            <div><button onclick="jixu()">继续</button></div>
        </div>
    </div>
</div>
<script type="text/javascript" src="plane/main.js"></script>
</body>
</html>
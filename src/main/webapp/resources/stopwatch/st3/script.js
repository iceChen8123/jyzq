if (document.location.search.match(/type=embed/gi)) {
  window.parent.postMessage('resize', "*");
}

window.requestAnimFrame = (function (callback) {
  return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame ||
	function (callback) {
		window.setTimeout(callback, 1000 / 60);
	};
})();

var graph = {
  'state': {
	  'pause': false,
	  'inUse': false,
	  'lapNum': 1
  },
  'markerStyle': {
	  'green': '#67d276',
	  'red': '#f73748'
  },
  'coords': {
	  'x': 5,
	  'y': 50,
	  'prev': {
		  'x': 0,
		  'y': 60
	  }
  },
  'msc': {
	  'fastestLap': 0,
	  'slowestLap': 99999999,
	  'startTime': 0
  }
};

//����Ԫ��
var lap_mil = document.getElementById('lap_mil'),
lap_sec = document.getElementById('lap_sec'),
lap_min = document.getElementById('lap_min'),
timer_mil = document.getElementById('timer_mil'),
timer_sec = document.getElementById('timer_sec'),
timer_min = document.getElementById('timer_min'),
watch = document.getElementById('watch'),
avg_time = document.getElementById('avg_time');

//ͼ��Ԫ��
var canvas = document.getElementById('graph'),
ctx = canvas.getContext('2d'),
lap = document.getElementById('lap'),
lap_numbers = document.getElementById('lap_numbers');

//��������
var clock,
lapClock,
interval,
lapOffset,
lapTotal,
laps = [],
breakLoop = 0;

var reset = 0;

var iWatch = function () {

  var startButton = addAction("start", start),
	stopButton = addAction("stop", stop),
	resetButton = addAction("reset", reset),
	lapButton = addAction("lap", lap);

  reset();

  function addAction(action, handler) {
	  var a = document.getElementById(action);
	  a.addEventListener("click", function (event) {
		  handler();
		  event.preventDefault();
	  });
	  return a;
  }

  function start() {
	  if (!interval) {
		  offset = Date.now();
		  watch.classList.add('go');
		  watch.classList.remove('pause');
		  startButton.classList.add('hide');
		  stopButton.classList.remove('hide');
		  resetButton.classList.add('hide');
		  lapButton.classList.remove('hide');
		  interval = setInterval(update, 1);
		  graph.state.pause = false;
		  if (!graph.state.inUse) {
			  breakLoop = 0;
			  graph.animate(canvas, ctx, graph.msc.startTime);
			  graph.state.inUse = true;
		  }
	  }
  }

  function stop() {
	  if (interval) {
		  watch.classList.add('pause');
		  startButton.classList.remove('hide');
		  stopButton.classList.add('hide');
		  resetButton.classList.remove('hide');
		  lapButton.classList.add('hide');
		  clearInterval(interval);
		  interval = null;
		  graph.state.pause = true;
	  }
  }

  function reset() {
	  clock = 0;
	  lapClock = 0;
	  lapOffset = 0;
	  lapTotal = 0;
	  watch.classList.remove('go');
	  watch.classList.remove('pause');
	  render();
	  graph.resetGraph(ctx, canvas);
  }

  function lap() {
	  //��ʱ
	  var temp = clock - lapTotal;

	  lapTotal += temp;
	  lapOffset = clock;
	  var val = graph.recordLap(graph.coords);

	  var current = {
		  'time_ms': temp,
		  'lap_number': val.lap_number,
		  'x': graph.coords.prev.x,
		  'y': graph.coords.prev.y
	  }
	  laps.push(current);
  }

  function update() {
	  clock += delta();
	  lapClock = clock - lapOffset;
	  render();
  }

  function render() {
	  var t_ms = (clock / 1000).toFixed(2),
		t_sec = parseInt(clock / 1000),
		t_min = parseInt(clock / 1000 / 60);

	  if (t_sec > 59) {
		  t_sec = t_sec - (60 * t_min);
	  }

	  timer_mil.innerHTML = (t_ms ? (t_ms > 9 ? t_ms : "0" + t_ms) : "00").slice(-2); // ms
	  timer_sec.innerHTML = (t_sec ? (t_sec > 9 ? t_sec : "0" + t_sec) : "00"); // sec
	  timer_min.innerHTML = (t_min ? (t_min > 9 ? t_min : "0" + t_min) : "00"); // min

	  var l_ms = (lapClock / 1000).toFixed(2),
		l_sec = parseInt(lapClock / 1000),
		l_min = parseInt(lapClock / 1000 / 60);

	  if (l_sec > 59) {
		  l_sec = l_sec - (60 * l_min);
	  }

	  lap_mil.innerHTML = (l_ms ? (l_ms > 9 ? l_ms : "0" + l_ms) : "00").slice(-2); // ms
	  lap_sec.innerHTML = (l_sec ? (l_sec > 9 ? l_sec : "0" + l_sec) : "00"); // sec
	  lap_min.innerHTML = (l_min ? (l_min > 9 ? l_min : "0" + l_min) : "00"); // min
  }

  function delta() {
	  var now = Date.now(),
		t = now - offset;
	  offset = now;
	  return t;
  }

  // public API
  this.start = start;
  this.stop = stop;
  this.reset = reset;
  this.lap = lap;
};

var clock = function () {
  var d = new Date(),
	time_hours = document.getElementById('time_hours'),
	time_mins = document.getElementById('time_mins');

  setInterval(function () {
	  setTime();
  }, 1000);

  function setTime() {
	  var hrs = d.getHours();
	  var mins = d.getMinutes();
	  time_hours.innerHTML = (hrs > 9 ? hrs : "0" + hrs);
	  time_mins.innerHTML = (mins > 9 ? mins : "0" + mins);
  }
  setTime();
}

graph.animate = function (canvas, c, startTime) {

  if (breakLoop == 1) {
	  breakLoop = 0;
	  return;
  }

  if (!graph.state.pause) {
	  var linearSpeed = 20;
	  var newY = linearSpeed * (startTime += 10) / 1000;

	  var offset = 0;
	  if (laps.length > 5) {
		  offset = (laps.length - 5) * 35;
	  }

	  if (newY < 50) {
		  graph.coords.y = 50 - newY;
	  }

	  if (reset == 1) {
		  //startTime = (new Date()).getTime();
		  startTime = 0;
		  reset = 0;
	  }

	  // ������ԭ
	  c.clearRect(0, 0, canvas.width, canvas.height);

	  // Draw average
	  if (graph.state.lapNum > 2) {

		  var totalY = 0,
			totalTime = 0;

		  for (var key in laps) {
			  if (laps.hasOwnProperty(key)) {
				  var lap = laps[key];
				  totalY += lap.y;
				  totalTime += lap.time_ms;
			  }
		  }

		  var meanY = totalY / laps.length;
		  var avgTime = totalTime / laps.length;

		  // Write average time
		  avgTime = Math.round(parseFloat(avgTime / 1000));
		  avg_time.innerHTML = Math.round(parseFloat(avgTime)) + 's';

		  // Draw mean line
		  c.beginPath();
		  c.setLineDash([2]);
		  c.strokeStyle = '#ffac39';
		  c.moveTo(0, meanY - 0.5);
		  c.lineTo(canvas.width, meanY - 0.5);
		  c.stroke();
		  c.closePath();
	  }

	  // Draw Connect Line
	  c.beginPath();
	  c.strokeStyle = '#fff';
	  c.setLineDash([0]);

	  if (graph.state.lapNum !== 1) {
		  c.moveTo(graph.coords.prev.x - offset, graph.coords.prev.y);
		  c.lineTo(graph.coords.x - offset, graph.coords.y);
	  }
	  c.stroke();
	  c.closePath();

	  //Draw Previous Markers
	  for (var key in laps) {
		  if (laps.hasOwnProperty(key)) {
			  var lap = laps[key];
			  c.beginPath();
			  c.strokeStyle = '#fff';
			  c.fillStyle = '#fff';
			  c.arc(lap.x - offset, lap.y, 2.5, 0, 2 * Math.PI, false);
			  c.fill();
			  c.closePath();

			  //Draw lap lap number
			  c.beginPath();
			  ctx.font = '14px helvetica';
			  ctx.fillText(lap.lap_number, lap.x - offset - 5, canvas.height - 10);
			  c.closePath();

			  //Draw Previous Line
			  if (lap.lap_number > 1) {
				  c.beginPath();
				  c.strokeStyle = '#fff';
				  c.moveTo(laps[key - 1].x - offset, laps[key - 1].y);
				  c.lineTo(lap.x - offset, lap.y);
				  c.stroke();
				  c.closePath();
			  }
		  }
	  }

	  //Draw Marker
	  c.beginPath();
	  if (graph.state.lapNum == 1) {
		  c.fillStyle = '#fff';
		  c.strokeStyle = '#fff';
	  } else {
		  if (graph.coords.y > graph.msc.fastestLap) {
			  c.fillStyle = graph.markerStyle.green;
			  c.strokeStyle = graph.markerStyle.green;
		  } else if (graph.coords.y < graph.msc.slowestLap) {
			  c.fillStyle = graph.markerStyle.red;
			  c.strokeStyle = graph.markerStyle.red;
		  } else {
			  c.fillStyle = '#fff';
			  c.strokeStyle = '#fff';
		  }
	  }
	  c.arc(graph.coords.x - offset, graph.coords.y, 2.5, 0, 2 * Math.PI, false);
	  c.fill();
	  c.closePath();

  }

  requestAnimFrame(function () {
	  graph.animate(canvas, c, startTime);
  });
}

graph.recordLap = function (c) {

  graph.coords.prev.x = c.x;
  graph.coords.prev.y = c.y;
  reset = 1;
  graph.coords.x += 35;

  if (graph.state.lapNum == 1) {
	  graph.msc.fastestLap = c.y;
  } else {
	  if (c.y > graph.msc.fastestLap) {
		  graph.msc.fastestLap = c.y;
	  } else if (c.y < graph.msc.slowestLap) {
		  graph.msc.slowestLap = c.y;
	  }
  }

  graph.state.lapNum++;

  return {
	  'x': c.x,
	  'y': c.y,
	  'lap_number': graph.state.lapNum - 1
  };
}

graph.resetGraph = function (ctx, canvas) {
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  lap_numbers.innerHTML = '';
  avg_time.innerHTML = '';
  graph.state.inUse = false;
  //graph.state.pause = false;
  graph.state.lapNum = 1;
  graph.coords.x = 5;
  graph.coords.y = 50;
  graph.coords.prev.x = 0;
  graph.coords.prev.y = 50;
  graph.msc.fastestLap = 0;
  graph.msc.slowestLap = 99999999;
  graph.msc.startTime = 0;
  graph.state.lapNum = 1;
  reset = 1;
  laps = [];
  breakLoop = 1;
}

// Initiate
clock();
var iWatch = new iWatch();
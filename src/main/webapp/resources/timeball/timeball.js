(function (D) {
    
    var _ = {
        extend: function (t, s, o) {
            if (o === undefined) o = true;
            for (var p in s) {
                if (!(p in t) || o) {
                    t[p] = s[p]
                }
            }
            return t;
        },
        addEvent: function (o, e, f) {
            o.addEventListener ? o.addEventListener(e, f, false) : o.attachEvent('on' + e, function () {f.call(o)})
        },
        $ : function (id) {
            return typeof id === 'string' ? D.getElementById(id) : id;
        },
        log : function (s) {
            !!window.console && console.log(s)
        }
    };
    
    var NUM = [
        '####   ##########  #####################    ',
        '#  #   #   #   ##  ##   #      ##  ##  #    ',
        '#  #   #   #   ##  ##   #      ##  ##  #  # ',
        '#  #   #####################   #########    ',
        '#  #   ##      #   #   ##  #   ##  #   #  # ',
        '#  #   ##      #   #   ##  #   ##  #   #    ',
        '####   #########   #########   #########    '
    ]
    //Math.floor:返回小于等于数字参数的最大整数
    var TM, tm, MF = Math.floor, ow = 10, od = 8, NT = [], _NT = [], scr, W, H, iPos = {}, e = 0, O = [], AO = {}, grid, gw, gh;
    
    function getTime () {
        // reset AO
        AO = {};
        
        tm = TM;
        var T = new Date(),
            h = T.getHours(),
            m = T.getMinutes(),
            s = T.getSeconds();
		//时钟显示的数字
        TM = [
            MF(h/10),
            h%10,
            MF(m/10),
            m%10,
            MF(s/10),
            s%10
        ];
        //_.log(tm+'\n'+TM)
		//每隔一秒刷新一次
        setTimeout(arguments.callee, 1000);
    }
    
    
    function toNT(TM, NT) {
        for (var i = 0; i < 7; i ++) {
            var temp = [];
            for (var j = 0; j < TM.length; j ++) {
                temp.push(NUM[i].substr(TM[j]*4, 4));
                if (j == 1 || j == 3) {
                    temp.push(NUM[i].substr(40, 4))
                }
            }
            NT[i] = temp.join('');
        }
    }
    
    function CNum () {
        toNT(TM, NT);
        if (tm && tm.length) {toNT(tm, _NT)}
        DrawNum();
		//每隔0.02秒刷新
        setTimeout(arguments.callee, 20)
    }
    
    function DrawNum () {
        //_.log(NT.length+'\n'+_NT.length)
        var ind = 0;
        for (var i = 0; i < NT.length; i ++) {
            for (var j = 0; j < NT[i].length; j ++) {
            
                var _char = '@', nchar = NT[i].charAt(j);
                
                var c = nchar === '#' ? 'blue' : 'gray';
                    
                if (nchar === '#') {
                    if (MF(j/4) < 3) c = 'red';
                    else if (MF(j/4) < 6) c = 'blue';
                    else if (MF(j/4) < 8) c = 'green';
                } else {
                    c = 'gray';
                }
                
                if (O.length >= 4*8*7) {
                    O[ind].o.className = c;
                    O[ind].o.style.left = j*(ow + od) + MF(j/4)*20 + iPos.x + 'px';
                    O[ind].o.style.top = i*(ow + od) + iPos.y + 'px';
                } else {
                    O.push(new Dot(c, {
                        l: j*(ow + od) + MF(j/4)*20 + iPos.x,
                        t: i*(ow + od) + iPos.y
                    }));
                }
                // dot anim
                if (_NT.length === 7) {
                    _char = _NT[i].charAt(j);
                    if (_char === '#' && nchar === ' ') {
                        var k = 'k'+i+'_'+j, _c;
                        if (MF(j/4) < 3) _c = 'red';
                        else if (MF(j/4) < 6) _c = 'blue';
                        else if (MF(j/4) < 8) _c = 'green';
                        if (!AO[k]) {
                            AO[k] = new Dot(_c, {
                                l: j*(ow + od) + MF(j/4)*20 + iPos.x,
                                t: i*(ow + od) + iPos.y
                            })
                            //_.log(k)
                            AO[k].anim()
                        }
                    }
                }
                
                ind ++;
            }
        }
    }
    //创建小圆点
    // DOT constructor
    function Dot (color, pos) {
        var g = Math.random();
            
        this.o = D.createElement('span');
        this.vx = this.vy = this.dx = this.dy = 0;
        this.vy = -this.randNum(1, 5);
        this.dir = Math.random() > .5 ? this.randNum(1, 5) : -1*this.randNum(1, 5);
        this.g = g < .1 ? .1 : g;
        this.x = pos.l;
        this.y = pos.t;
        scr.appendChild(this.o);
        
        this.setStyle(color, pos);
    }
    _.extend(Dot.prototype, {
        setStyle: function (c, pos) {
            var sty = this.o.style;
            this.o.className = c;
            sty['width'] = ow + 'px';
            sty['height'] = ow + 'px';
            sty['position'] = 'absolute';
            sty['left'] = pos.l + 'px';
            sty['top'] = pos.t + 'px';
        },
        randNum: function (f, t) {
            return Math.round(Math.random()*(t-f)) + f;
        },
		//小球移动函数
        move: function () {
            this.x += this.dx;
            this.y += this.dy;
            this.vx += this.dx;
            this.vy += this.dy;
            //通过样式进行移动
            this.o.style['left'] = this.x + 'px';
            this.o.style['top'] = this.y + 'px';
            
        },
		//边界检测函数
        boundary: function () {
            //gravity
            this.vy += this.g;
            this.x += this.dir;
            this.y += this.vy;
            
            if (this.x < 0  || this.x > W) {
			    //出界以后停止小球的计时器
                clearInterval(this.st);
                scr.removeChild(this.o);
            }
            
            if (this.y > H-10 && this.vy > 0) {
                this.vy *= -1;
            }
            
            
        },
        anim: function () {
            var _this = this;
            this.st = setInterval(function () {
                _this.move();
                _this.boundary();
            }, 16)
        }
    })
    
    function resize () {
        W = scr.offsetWidth;
        H = scr.offsetHeight;
        iPos.x = (W-32*(ow+od)-20*8)/2;
        iPos.y = (H-7*(ow+od))/2;
    }
    
    // init
    _.addEvent(window, 'load', function () {
        scr = _.$('screen');
        resize();
        getTime();
        CNum();
        
        gw = Math.round(W/10); 
        gh = Math.round(H/10);
        grid = new Array(gw * gh);
    })
    _.addEvent(window, 'resize', resize)
    
})(document)
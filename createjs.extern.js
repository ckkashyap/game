var createjs = {}

createjs.Shape = function() {
}


createjs.Graphics=function() {
}

createjs.Bitmap=function(a){
    return {
	getBounds: function () {
	    return {
		width: 1
	    }
	}
    }

}


createjs.Bitmap("A").scaleX = 1;
createjs.Bitmap("A").scaleY = 1;
createjs.Bitmap("A").getBounds().width = 1;

createjs.Stage = function(a) {
    return {
	addChild: function(o) {
	},
	update: function() {
	}
    }
}

var Ticker={}

Ticker.addEventListener = function (p1, p2) {
}



createjs.graphics.beginFill=function(a) {
    return {
	drawCircle: function (a, b, c, d) {
	}
    }
}


createjs.graphics.beginFill("A").drawCircle(1,2,3,4);

createjs.Stage("A").addChild("A");

createjs.Stage("A").update();


createjs.graphics.beginStroke("A").beginFill("A").drawRect(0,1,2,3);

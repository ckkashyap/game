var createjs = {}

createjs.Shape = function() {
}

createjs.Stage = function(a) {
    return {
	addChild: function(o) {
	},
	update: function() {
	}
    }
}

var graphics= {}

graphics.beginFill=function(a) {
    return {
	drawCircle: function (a, b, c, d) {
	}
    }
}

graphics.beginFill("A").drawCircle(1,2,3,4);

createjs.Stage("A").addChild("A");

createjs.Stage("A").update();


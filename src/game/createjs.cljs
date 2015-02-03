(ns game.createjs)


(defn newStage [canvas]
  (new  js/createjs.Stage canvas))

(defn newShape 
  ([]  (new js/createjs.Shape))
  ([g] (new js/createjs.Shape g))
)

(defn newBitmap
  ([n] (new js/createjs.Bitmap n))
)


(defn newGraphics []
  (new js/createjs.Graphics))

(defn drawCircle [x y r c]
  (let [shape (newShape)]
    (.drawCircle (.beginFill (.-graphics shape) c) x y r)
    shape))

(defn addChild [s c]
  (.addChild s c))

(defn updateStage [s]
  (.update s))


(defn addEventListener [e f]
    (.addEventListener (.-Ticker js/createjs) e f))


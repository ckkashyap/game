(ns game.createjs)


(defn newStage [canvas]
  (new  js/createjs.Stage canvas))

(defn newShape []
  (new js/createjs.Shape))

(defn drawCircle [x y r c]
  (let [shape (newShape)]
    (.drawCircle (.beginFill (.-graphics shape) c) x y r)
    shape))

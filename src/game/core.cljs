(ns game.core 
  (:require
   [game.gameLoop :as gameloop]
   [game.createjs :as createjs]
   [game.consts :as consts]
  )
)

(enable-console-print!)

(def globalNumberOfTracks 7)

(defn initializeScreen [stage canvas numberOfTracks]
  (let
      [
       width (.-width canvas)
       height (.-width canvas)
       trackWidth (/ width numberOfTracks)
       ]
    (dotimes [i numberOfTracks]
      (let [
            g (createjs/newGraphics)
            s (createjs/newShape g)
            ]
        (.drawRect (.beginFill (.beginStroke g "#F00") "#00F") (* trackWidth i) 0 (* trackWidth ( + i 1)) height)
        (.addChild stage s)
       ))))

(defn ^:export init []
  (let [
        stage (createjs/newStage "demoCanvas")
        canvas (.getElementById js/document "demoCanvas")
        _ (set! (.-width canvas) (consts/screen-width))
        _ (initializeScreen stage canvas globalNumberOfTracks)
        _ (createjs/updateStage stage)

        ]
    (def state {
                :stage stage
                :canvas canvas
                :counter 0
                })
    (createjs/addEventListener "tick"
                       (fn []
                         (set! state 
                               (let [ 
                                     counter (:counter state)
                                     oldState (gameloop/loopFunction state)
                                     ] 
                                 (assoc oldState :counter (+ 1 counter))))
                         (createjs/updateStage stage)
                         )
                       )
    ))


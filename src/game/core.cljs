(ns game.core 
  (:require
   [game.gameLoop :as gameloop]
   [game.createjs :as createjs]
  )
)

(enable-console-print!)

(defn ^:export init []
  (let [
        stage (createjs/newStage "demoCanvas")
        c (createjs/drawCircle 100 5 50 "Red")
        _ (createjs/addChild stage c)
        _ (createjs/update stage)

        ]
    (def state {:stage stage :circle c})
    (createjs/addEventListener "tick"
                       (fn []
                         (set! state (gameloop/loopFunction state))
                         (createjs/update stage)
                         )
                       )
    ))



(println "Hello world!")

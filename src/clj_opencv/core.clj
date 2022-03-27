(ns clj-opencv.core
  (:require [opencv4.core :refer :all]
            [opencv4.utils :as u]))


(declare transfrm)

(def inter (fn[x] (transfrm x)))
(u/simple-cam-window inter)

(def transfrm (fn[x] (-> x
                         (flip! 1)
                         (gaussian-blur! (new-size 1 1) 1 1)
                         (cvt-color! COLOR_BGR2GRAY)
                         (filter-2-d! -1 (u/matrix-to-mat
                                          [[-3 -3 -3]
                                           [-3 0 -3]
                                           [5 5 5]])))))


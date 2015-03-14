(ns discrete.tree)

(defn make-tree
  ([value] (value))
  ([value child child] (value child child)))
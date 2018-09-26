Installation
---------------

Supersafe (community edition) installation:

1. Add the Artima Maven Repository as a resolver in ~/.sbt/1.0/global.sbt, like this:

    resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"

2. Add the following line to your project/plugins.sbt:

    addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.7")


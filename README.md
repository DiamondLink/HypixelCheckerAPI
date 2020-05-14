# HypixelCheckerAPI
API to use in youre minecraft forge mod, which provide info and features about the games...
See the features below

## Intallation
- Download the api from release
- Put it in a "libs" folder in youre project
- Add it to build path
- Then import it :
```java
import api.java.checker.api.CheckerAPI;
```

## Exemple features
Is the player on hypixel ?
```java
CheckerAPI.getValues().isOnHypixel();
```
Is the player in a world ?
```java
CheckerAPI.getValues().isInAWorld();
```
Is the player in singleplayer ?
```java
CheckerAPI.getValues().isOnSinglePlayer();
```
Update the hypixel game value
```java
CheckerAPI.getManager().updateMapValue()
```
So you can get which game the player is playing (on hypixel)
```java
CheckerAPI.getValues().getHypixelGame();
```
Automaticly reconnect to a server
```java
CheckerAPI.getManager().autoReconnect(serverIpToReconnectTo);
```
Connect to a server from menu
```java
CheckerAPI.getManager().connectToAServer(serverConnexion);
```
Disconnect from a server
```java
CheckerAPI.getManager().disconnectFromServer(isOnTheServer);
```
And many other features...



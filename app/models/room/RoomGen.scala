package room

trait RoomGen {
  def genRoomCode: String
}

object RoomGenFact {
  def getRoomGen: RoomGen = RoomGenImpl
}

private object RoomGenImpl extends RoomGen {
  private var occupied: List[Room] = Nil

  override def genRoomCode: String = {
    var curRoom: Room = genRoom
    while(occupied.exists(_==curRoom))
      curRoom = genRoom
    addRoom(curRoom)
    curRoom.roomID
  }

  private def addRoom(x: Room): Unit = 
    occupied = x::occupied

  private def removeRoom(x: Room) = 
    occupied = occupied.filterNot(_==x)
  
  private def genRoom: Room = {
    Room(genRandCharString)
  }

  // TODO - make this generate an actual random string of characters
  private def genRandCharString: String =
    "placeholder"
}

private case class Room(roomID: String)


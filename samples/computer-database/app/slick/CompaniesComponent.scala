package slick

import com.github.stonexx.slick.ext.ExtJdbcProfile
import models.Company
import play.api.db.slick.HasDatabaseConfig
import slick.lifted.ProvenShape

trait CompaniesComponent { this: HasDatabaseConfig[ExtJdbcProfile] =>
  import profile.api._

  class Companies(tag: Tag) extends Table[Company](tag, "COMPANY") {

    def id: Rep[Long] = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def name: Rep[String] = column[String]("NAME")

    def * : ProvenShape[Company] = (id.?, name).mapTo[Company]
  }
}

package model
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object HelloActiveAdm extends {
  val profile = slick.driver.MySQLDriver
} with HelloActiveAdm

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait HelloActiveAdm {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(AdminUsers.schema, AdminUsersRoles.schema, ArInternalMetadata.schema, CkeditorAssets.schema, P10Dinners.schema, P1Simples.schema, P2Simples.schema, P3Children.schema, P3Parents.schema, P4Assigns.schema, P4Children.schema, P4Parents.schema, P5UseImgs.schema, P6Groups.schema, P6GroupsUsers.schema, P6Users.schema, P7Scaffolds.schema, P8Hellos.schema, P9Hellos.schema, Roles.schema, SchemaMigrations.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table AdminUsers
   *  @param email Database column email SqlType(VARCHAR), Length(255,true), Default()
   *  @param encryptedPassword Database column encrypted_password SqlType(VARCHAR), Length(255,true), Default()
   *  @param resetPasswordToken Database column reset_password_token SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param resetPasswordSentAt Database column reset_password_sent_at SqlType(DATETIME), Default(None)
   *  @param rememberCreatedAt Database column remember_created_at SqlType(DATETIME), Default(None)
   *  @param signInCount Database column sign_in_count SqlType(INT), Default(0)
   *  @param currentSignInAt Database column current_sign_in_at SqlType(DATETIME), Default(None)
   *  @param lastSignInAt Database column last_sign_in_at SqlType(DATETIME), Default(None)
   *  @param currentSignInIp Database column current_sign_in_ip SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param lastSignInIp Database column last_sign_in_ip SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param admin Database column admin SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class AdminUsersRow(email: String = "", encryptedPassword: String = "", resetPasswordToken: Option[String] = None, resetPasswordSentAt: Option[java.sql.Timestamp] = None, rememberCreatedAt: Option[java.sql.Timestamp] = None, signInCount: Int = 0, currentSignInAt: Option[java.sql.Timestamp] = None, lastSignInAt: Option[java.sql.Timestamp] = None, currentSignInIp: Option[String] = None, lastSignInIp: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, admin: Option[String] = None, id: Option[Int] = None)
  /** GetResult implicit for fetching AdminUsersRow objects using plain SQL queries */
  implicit def GetResultAdminUsersRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]], e3: GR[Int], e4: GR[java.sql.Timestamp], e5: GR[Option[Int]]): GR[AdminUsersRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<[String], <<[String], <<?[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[String])
    import r._
    AdminUsersRow.tupled((_2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _1)) // putting AutoInc last
  }
  /** Table description of table admin_users. Objects of this class serve as prototypes for rows in queries. */
  class AdminUsers(_tableTag: Tag) extends Table[AdminUsersRow](_tableTag, "admin_users") {
    def * = (email, encryptedPassword, resetPasswordToken, resetPasswordSentAt, rememberCreatedAt, signInCount, currentSignInAt, lastSignInAt, currentSignInIp, lastSignInIp, createdAt, updatedAt, admin, Rep.Some(id)) <> (AdminUsersRow.tupled, AdminUsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(email), Rep.Some(encryptedPassword), resetPasswordToken, resetPasswordSentAt, rememberCreatedAt, Rep.Some(signInCount), currentSignInAt, lastSignInAt, currentSignInIp, lastSignInIp, Rep.Some(createdAt), Rep.Some(updatedAt), admin, Rep.Some(id)).shaped.<>({r=>import r._; _1.map(_=> AdminUsersRow.tupled((_1.get, _2.get, _3, _4, _5, _6.get, _7, _8, _9, _10, _11.get, _12.get, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column email SqlType(VARCHAR), Length(255,true), Default() */
    val email: Rep[String] = column[String]("email", O.Length(255,varying=true), O.Default(""))
    /** Database column encrypted_password SqlType(VARCHAR), Length(255,true), Default() */
    val encryptedPassword: Rep[String] = column[String]("encrypted_password", O.Length(255,varying=true), O.Default(""))
    /** Database column reset_password_token SqlType(VARCHAR), Length(255,true), Default(None) */
    val resetPasswordToken: Rep[Option[String]] = column[Option[String]]("reset_password_token", O.Length(255,varying=true), O.Default(None))
    /** Database column reset_password_sent_at SqlType(DATETIME), Default(None) */
    val resetPasswordSentAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("reset_password_sent_at", O.Default(None))
    /** Database column remember_created_at SqlType(DATETIME), Default(None) */
    val rememberCreatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("remember_created_at", O.Default(None))
    /** Database column sign_in_count SqlType(INT), Default(0) */
    val signInCount: Rep[Int] = column[Int]("sign_in_count", O.Default(0))
    /** Database column current_sign_in_at SqlType(DATETIME), Default(None) */
    val currentSignInAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("current_sign_in_at", O.Default(None))
    /** Database column last_sign_in_at SqlType(DATETIME), Default(None) */
    val lastSignInAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("last_sign_in_at", O.Default(None))
    /** Database column current_sign_in_ip SqlType(VARCHAR), Length(255,true), Default(None) */
    val currentSignInIp: Rep[Option[String]] = column[Option[String]]("current_sign_in_ip", O.Length(255,varying=true), O.Default(None))
    /** Database column last_sign_in_ip SqlType(VARCHAR), Length(255,true), Default(None) */
    val lastSignInIp: Rep[Option[String]] = column[Option[String]]("last_sign_in_ip", O.Length(255,varying=true), O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column admin SqlType(VARCHAR), Length(255,true), Default(None) */
    val admin: Rep[Option[String]] = column[Option[String]]("admin", O.Length(255,varying=true), O.Default(None))
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)

    /** Uniqueness Index over (email) (database name index_admin_users_on_email) */
    val index1 = index("index_admin_users_on_email", email, unique=true)
    /** Uniqueness Index over (resetPasswordToken) (database name index_admin_users_on_reset_password_token) */
    val index2 = index("index_admin_users_on_reset_password_token", resetPasswordToken, unique=true)
  }
  /** Collection-like TableQuery object for table AdminUsers */
  lazy val AdminUsers = new TableQuery(tag => new AdminUsers(tag))

  /** Entity class storing rows of table AdminUsersRoles
   *  @param adminUserId Database column admin_user_id SqlType(INT), Default(None)
   *  @param roleId Database column role_id SqlType(INT), Default(None) */
  case class AdminUsersRolesRow(adminUserId: Option[Int] = None, roleId: Option[Int] = None)
  /** GetResult implicit for fetching AdminUsersRolesRow objects using plain SQL queries */
  implicit def GetResultAdminUsersRolesRow(implicit e0: GR[Option[Int]]): GR[AdminUsersRolesRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[Int])
    import r._
    AdminUsersRolesRow.tupled((_1, _2)) // putting AutoInc last
  }
  /** Table description of table admin_users_roles. Objects of this class serve as prototypes for rows in queries. */
  class AdminUsersRoles(_tableTag: Tag) extends Table[AdminUsersRolesRow](_tableTag, "admin_users_roles") {
    def * = (adminUserId, roleId) <> (AdminUsersRolesRow.tupled, AdminUsersRolesRow.unapply)

    /** Database column admin_user_id SqlType(INT), Default(None) */
    val adminUserId: Rep[Option[Int]] = column[Option[Int]]("admin_user_id", O.Default(None))
    /** Database column role_id SqlType(INT), Default(None) */
    val roleId: Rep[Option[Int]] = column[Option[Int]]("role_id", O.Default(None))

    /** Index over (adminUserId,roleId) (database name index_admin_users_roles_on_admin_user_id_and_role_id) */
    val index1 = index("index_admin_users_roles_on_admin_user_id_and_role_id", (adminUserId, roleId))
  }
  /** Collection-like TableQuery object for table AdminUsersRoles */
  lazy val AdminUsersRoles = new TableQuery(tag => new AdminUsersRoles(tag))

  /** Entity class storing rows of table ArInternalMetadata
   *  @param key Database column key SqlType(VARCHAR), PrimaryKey, Length(255,true)
   *  @param value Database column value SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME) */
  case class ArInternalMetadataRow(key: String, value: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp)
  /** GetResult implicit for fetching ArInternalMetadataRow objects using plain SQL queries */
  implicit def GetResultArInternalMetadataRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[ArInternalMetadataRow] = GR{
    prs => import prs._
    val r = (<<[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    ArInternalMetadataRow.tupled((_1, _2, _3, _4)) // putting AutoInc last
  }
  /** Table description of table ar_internal_metadata. Objects of this class serve as prototypes for rows in queries. */
  class ArInternalMetadata(_tableTag: Tag) extends Table[ArInternalMetadataRow](_tableTag, "ar_internal_metadata") {
    def * = (key, value, createdAt, updatedAt) <> (ArInternalMetadataRow.tupled, ArInternalMetadataRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(key), value, Rep.Some(createdAt), Rep.Some(updatedAt)).shaped.<>({r=>import r._; _1.map(_=> ArInternalMetadataRow.tupled((_1.get, _2, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column key SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val key: Rep[String] = column[String]("key", O.PrimaryKey, O.Length(255,varying=true))
    /** Database column value SqlType(VARCHAR), Length(255,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("value", O.Length(255,varying=true), O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
  }
  /** Collection-like TableQuery object for table ArInternalMetadata */
  lazy val ArInternalMetadata = new TableQuery(tag => new ArInternalMetadata(tag))

  /** Entity class storing rows of table CkeditorAssets
   *  @param dataFileName Database column data_file_name SqlType(VARCHAR), Length(255,true)
   *  @param dataContentType Database column data_content_type SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param dataFileSize Database column data_file_size SqlType(INT), Default(None)
   *  @param `type` Database column type SqlType(VARCHAR), Length(30,true), Default(None)
   *  @param width Database column width SqlType(INT), Default(None)
   *  @param height Database column height SqlType(INT), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class CkeditorAssetsRow(dataFileName: String, dataContentType: Option[String] = None, dataFileSize: Option[Int] = None, `type`: Option[String] = None, width: Option[Int] = None, height: Option[Int] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching CkeditorAssetsRow objects using plain SQL queries */
  implicit def GetResultCkeditorAssetsRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[java.sql.Timestamp]): GR[CkeditorAssetsRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<[String], <<?[String], <<?[Int], <<?[String], <<?[Int], <<?[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    CkeditorAssetsRow.tupled((_2, _3, _4, _5, _6, _7, _8, _9, _1)) // putting AutoInc last
  }
  /** Table description of table ckeditor_assets. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class CkeditorAssets(_tableTag: Tag) extends Table[CkeditorAssetsRow](_tableTag, "ckeditor_assets") {
    def * = (dataFileName, dataContentType, dataFileSize, `type`, width, height, createdAt, updatedAt, Rep.Some(id)) <> (CkeditorAssetsRow.tupled, CkeditorAssetsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(dataFileName), dataContentType, dataFileSize, `type`, width, height, Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _1.map(_=> CkeditorAssetsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7.get, _8.get, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column data_file_name SqlType(VARCHAR), Length(255,true) */
    val dataFileName: Rep[String] = column[String]("data_file_name", O.Length(255,varying=true))
    /** Database column data_content_type SqlType(VARCHAR), Length(255,true), Default(None) */
    val dataContentType: Rep[Option[String]] = column[Option[String]]("data_content_type", O.Length(255,varying=true), O.Default(None))
    /** Database column data_file_size SqlType(INT), Default(None) */
    val dataFileSize: Rep[Option[Int]] = column[Option[Int]]("data_file_size", O.Default(None))
    /** Database column type SqlType(VARCHAR), Length(30,true), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[String]] = column[Option[String]]("type", O.Length(30,varying=true), O.Default(None))
    /** Database column width SqlType(INT), Default(None) */
    val width: Rep[Option[Int]] = column[Option[Int]]("width", O.Default(None))
    /** Database column height SqlType(INT), Default(None) */
    val height: Rep[Option[Int]] = column[Option[Int]]("height", O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)

    /** Index over (`type`) (database name index_ckeditor_assets_on_type) */
    val index1 = index("index_ckeditor_assets_on_type", `type`)
  }
  /** Collection-like TableQuery object for table CkeditorAssets */
  lazy val CkeditorAssets = new TableQuery(tag => new CkeditorAssets(tag))

  /** Entity class storing rows of table P10Dinners
   *  @param title Database column title SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param zensaiTitle Database column zensai_title SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param zensaiDetail Database column zensai_detail SqlType(TEXT), Default(None)
   *  @param fishTitle Database column fish_title SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param fishDetail Database column fish_detail SqlType(TEXT), Default(None)
   *  @param meatTitle Database column meat_title SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param meatDetail Database column meat_detail SqlType(TEXT), Default(None)
   *  @param mainTitle Database column main_title SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param mainDetail Database column main_detail SqlType(TEXT), Default(None)
   *  @param dessertTitle Database column dessert_title SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param dessertDetail Database column dessert_detail SqlType(TEXT), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P10DinnersRow(title: Option[String] = None, zensaiTitle: Option[String] = None, zensaiDetail: Option[String] = None, fishTitle: Option[String] = None, fishDetail: Option[String] = None, meatTitle: Option[String] = None, meatDetail: Option[String] = None, mainTitle: Option[String] = None, mainDetail: Option[String] = None, dessertTitle: Option[String] = None, dessertDetail: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching P10DinnersRow objects using plain SQL queries */
  implicit def GetResultP10DinnersRow(implicit e0: GR[Option[String]], e1: GR[java.sql.Timestamp], e2: GR[Option[Int]]): GR[P10DinnersRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    P10DinnersRow.tupled((_2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _1)) // putting AutoInc last
  }
  /** Table description of table p10_dinners. Objects of this class serve as prototypes for rows in queries. */
  class P10Dinners(_tableTag: Tag) extends Table[P10DinnersRow](_tableTag, "p10_dinners") {
    def * = (title, zensaiTitle, zensaiDetail, fishTitle, fishDetail, meatTitle, meatDetail, mainTitle, mainDetail, dessertTitle, dessertDetail, createdAt, updatedAt, Rep.Some(id)) <> (P10DinnersRow.tupled, P10DinnersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (title, zensaiTitle, zensaiDetail, fishTitle, fishDetail, meatTitle, meatDetail, mainTitle, mainDetail, dessertTitle, dessertDetail, Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _12.map(_=> P10DinnersRow.tupled((_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12.get, _13.get, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column title SqlType(VARCHAR), Length(255,true), Default(None) */
    val title: Rep[Option[String]] = column[Option[String]]("title", O.Length(255,varying=true), O.Default(None))
    /** Database column zensai_title SqlType(VARCHAR), Length(255,true), Default(None) */
    val zensaiTitle: Rep[Option[String]] = column[Option[String]]("zensai_title", O.Length(255,varying=true), O.Default(None))
    /** Database column zensai_detail SqlType(TEXT), Default(None) */
    val zensaiDetail: Rep[Option[String]] = column[Option[String]]("zensai_detail", O.Default(None))
    /** Database column fish_title SqlType(VARCHAR), Length(255,true), Default(None) */
    val fishTitle: Rep[Option[String]] = column[Option[String]]("fish_title", O.Length(255,varying=true), O.Default(None))
    /** Database column fish_detail SqlType(TEXT), Default(None) */
    val fishDetail: Rep[Option[String]] = column[Option[String]]("fish_detail", O.Default(None))
    /** Database column meat_title SqlType(VARCHAR), Length(255,true), Default(None) */
    val meatTitle: Rep[Option[String]] = column[Option[String]]("meat_title", O.Length(255,varying=true), O.Default(None))
    /** Database column meat_detail SqlType(TEXT), Default(None) */
    val meatDetail: Rep[Option[String]] = column[Option[String]]("meat_detail", O.Default(None))
    /** Database column main_title SqlType(VARCHAR), Length(255,true), Default(None) */
    val mainTitle: Rep[Option[String]] = column[Option[String]]("main_title", O.Length(255,varying=true), O.Default(None))
    /** Database column main_detail SqlType(TEXT), Default(None) */
    val mainDetail: Rep[Option[String]] = column[Option[String]]("main_detail", O.Default(None))
    /** Database column dessert_title SqlType(VARCHAR), Length(255,true), Default(None) */
    val dessertTitle: Rep[Option[String]] = column[Option[String]]("dessert_title", O.Length(255,varying=true), O.Default(None))
    /** Database column dessert_detail SqlType(TEXT), Default(None) */
    val dessertDetail: Rep[Option[String]] = column[Option[String]]("dessert_detail", O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P10Dinners */
  lazy val P10Dinners = new TableQuery(tag => new P10Dinners(tag))

  /** Entity class storing rows of table P1Simples
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P1SimplesRow(createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching P1SimplesRow objects using plain SQL queries */
  implicit def GetResultP1SimplesRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]]): GR[P1SimplesRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    P1SimplesRow.tupled((_2, _3, _1)) // putting AutoInc last
  }
  /** Table description of table p1_simples. Objects of this class serve as prototypes for rows in queries. */
  class P1Simples(_tableTag: Tag) extends Table[P1SimplesRow](_tableTag, "p1_simples") {
    def * = (createdAt, updatedAt, Rep.Some(id)) <> (P1SimplesRow.tupled, P1SimplesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _1.map(_=> P1SimplesRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P1Simples */
  lazy val P1Simples = new TableQuery(tag => new P1Simples(tag))

  /** Entity class storing rows of table P2Simples
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param age Database column age SqlType(INT), Default(None)
   *  @param memo Database column memo SqlType(TEXT), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P2SimplesRow(name: Option[String] = None, age: Option[Int] = None, memo: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching P2SimplesRow objects using plain SQL queries */
  implicit def GetResultP2SimplesRow(implicit e0: GR[Option[String]], e1: GR[Option[Int]], e2: GR[java.sql.Timestamp]): GR[P2SimplesRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[Int], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    P2SimplesRow.tupled((_2, _3, _4, _5, _6, _1)) // putting AutoInc last
  }
  /** Table description of table p2_simples. Objects of this class serve as prototypes for rows in queries. */
  class P2Simples(_tableTag: Tag) extends Table[P2SimplesRow](_tableTag, "p2_simples") {
    def * = (name, age, memo, createdAt, updatedAt, Rep.Some(id)) <> (P2SimplesRow.tupled, P2SimplesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (name, age, memo, Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _4.map(_=> P2SimplesRow.tupled((_1, _2, _3, _4.get, _5.get, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column age SqlType(INT), Default(None) */
    val age: Rep[Option[Int]] = column[Option[Int]]("age", O.Default(None))
    /** Database column memo SqlType(TEXT), Default(None) */
    val memo: Rep[Option[String]] = column[Option[String]]("memo", O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P2Simples */
  lazy val P2Simples = new TableQuery(tag => new P2Simples(tag))

  /** Entity class storing rows of table P3Children
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param address Database column address SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param bita Database column bita SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param p3ParentId Database column p3_parent_id SqlType(INT), Default(None)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P3ChildrenRow(name: Option[String] = None, address: Option[String] = None, bita: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, p3ParentId: Option[Int] = None, id: Option[Int] = None)
  /** GetResult implicit for fetching P3ChildrenRow objects using plain SQL queries */
  implicit def GetResultP3ChildrenRow(implicit e0: GR[Option[String]], e1: GR[java.sql.Timestamp], e2: GR[Option[Int]]): GR[P3ChildrenRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[Int])
    import r._
    P3ChildrenRow.tupled((_2, _3, _4, _5, _6, _7, _1)) // putting AutoInc last
  }
  /** Table description of table p3_children. Objects of this class serve as prototypes for rows in queries. */
  class P3Children(_tableTag: Tag) extends Table[P3ChildrenRow](_tableTag, "p3_children") {
    def * = (name, address, bita, createdAt, updatedAt, p3ParentId, Rep.Some(id)) <> (P3ChildrenRow.tupled, P3ChildrenRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (name, address, bita, Rep.Some(createdAt), Rep.Some(updatedAt), p3ParentId, Rep.Some(id)).shaped.<>({r=>import r._; _4.map(_=> P3ChildrenRow.tupled((_1, _2, _3, _4.get, _5.get, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column address SqlType(VARCHAR), Length(255,true), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Length(255,varying=true), O.Default(None))
    /** Database column bita SqlType(VARCHAR), Length(255,true), Default(None) */
    val bita: Rep[Option[String]] = column[Option[String]]("bita", O.Length(255,varying=true), O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column p3_parent_id SqlType(INT), Default(None) */
    val p3ParentId: Rep[Option[Int]] = column[Option[Int]]("p3_parent_id", O.Default(None))
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P3Children */
  lazy val P3Children = new TableQuery(tag => new P3Children(tag))

  /** Entity class storing rows of table P3Parents
   *  @param title Database column title SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param pre Database column pre SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P3ParentsRow(title: Option[String] = None, pre: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching P3ParentsRow objects using plain SQL queries */
  implicit def GetResultP3ParentsRow(implicit e0: GR[Option[String]], e1: GR[java.sql.Timestamp], e2: GR[Option[Int]]): GR[P3ParentsRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    P3ParentsRow.tupled((_2, _3, _4, _5, _1)) // putting AutoInc last
  }
  /** Table description of table p3_parents. Objects of this class serve as prototypes for rows in queries. */
  class P3Parents(_tableTag: Tag) extends Table[P3ParentsRow](_tableTag, "p3_parents") {
    def * = (title, pre, createdAt, updatedAt, Rep.Some(id)) <> (P3ParentsRow.tupled, P3ParentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (title, pre, Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _3.map(_=> P3ParentsRow.tupled((_1, _2, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column title SqlType(VARCHAR), Length(255,true), Default(None) */
    val title: Rep[Option[String]] = column[Option[String]]("title", O.Length(255,varying=true), O.Default(None))
    /** Database column pre SqlType(VARCHAR), Length(255,true), Default(None) */
    val pre: Rep[Option[String]] = column[Option[String]]("pre", O.Length(255,varying=true), O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P3Parents */
  lazy val P3Parents = new TableQuery(tag => new P3Parents(tag))

  /** Entity class storing rows of table P4Assigns
   *  @param p4ParentId Database column p4_parent_id SqlType(INT), Default(None)
   *  @param p4ChildId Database column p4_child_id SqlType(INT), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P4AssignsRow(p4ParentId: Option[Int] = None, p4ChildId: Option[Int] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching P4AssignsRow objects using plain SQL queries */
  implicit def GetResultP4AssignsRow(implicit e0: GR[Option[Int]], e1: GR[java.sql.Timestamp]): GR[P4AssignsRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[Int], <<?[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    P4AssignsRow.tupled((_2, _3, _4, _5, _1)) // putting AutoInc last
  }
  /** Table description of table p4_assigns. Objects of this class serve as prototypes for rows in queries. */
  class P4Assigns(_tableTag: Tag) extends Table[P4AssignsRow](_tableTag, "p4_assigns") {
    def * = (p4ParentId, p4ChildId, createdAt, updatedAt, Rep.Some(id)) <> (P4AssignsRow.tupled, P4AssignsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (p4ParentId, p4ChildId, Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _3.map(_=> P4AssignsRow.tupled((_1, _2, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column p4_parent_id SqlType(INT), Default(None) */
    val p4ParentId: Rep[Option[Int]] = column[Option[Int]]("p4_parent_id", O.Default(None))
    /** Database column p4_child_id SqlType(INT), Default(None) */
    val p4ChildId: Rep[Option[Int]] = column[Option[Int]]("p4_child_id", O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P4Assigns */
  lazy val P4Assigns = new TableQuery(tag => new P4Assigns(tag))

  /** Entity class storing rows of table P4Children
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param address Database column address SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param bita Database column bita SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P4ChildrenRow(name: Option[String] = None, address: Option[String] = None, bita: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching P4ChildrenRow objects using plain SQL queries */
  implicit def GetResultP4ChildrenRow(implicit e0: GR[Option[String]], e1: GR[java.sql.Timestamp], e2: GR[Option[Int]]): GR[P4ChildrenRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    P4ChildrenRow.tupled((_2, _3, _4, _5, _6, _1)) // putting AutoInc last
  }
  /** Table description of table p4_children. Objects of this class serve as prototypes for rows in queries. */
  class P4Children(_tableTag: Tag) extends Table[P4ChildrenRow](_tableTag, "p4_children") {
    def * = (name, address, bita, createdAt, updatedAt, Rep.Some(id)) <> (P4ChildrenRow.tupled, P4ChildrenRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (name, address, bita, Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _4.map(_=> P4ChildrenRow.tupled((_1, _2, _3, _4.get, _5.get, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column address SqlType(VARCHAR), Length(255,true), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Length(255,varying=true), O.Default(None))
    /** Database column bita SqlType(VARCHAR), Length(255,true), Default(None) */
    val bita: Rep[Option[String]] = column[Option[String]]("bita", O.Length(255,varying=true), O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P4Children */
  lazy val P4Children = new TableQuery(tag => new P4Children(tag))

  /** Entity class storing rows of table P4Parents
   *  @param title Database column title SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param pre Database column pre SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P4ParentsRow(title: Option[String] = None, pre: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching P4ParentsRow objects using plain SQL queries */
  implicit def GetResultP4ParentsRow(implicit e0: GR[Option[String]], e1: GR[java.sql.Timestamp], e2: GR[Option[Int]]): GR[P4ParentsRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    P4ParentsRow.tupled((_2, _3, _4, _5, _1)) // putting AutoInc last
  }
  /** Table description of table p4_parents. Objects of this class serve as prototypes for rows in queries. */
  class P4Parents(_tableTag: Tag) extends Table[P4ParentsRow](_tableTag, "p4_parents") {
    def * = (title, pre, createdAt, updatedAt, Rep.Some(id)) <> (P4ParentsRow.tupled, P4ParentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (title, pre, Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _3.map(_=> P4ParentsRow.tupled((_1, _2, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column title SqlType(VARCHAR), Length(255,true), Default(None) */
    val title: Rep[Option[String]] = column[Option[String]]("title", O.Length(255,varying=true), O.Default(None))
    /** Database column pre SqlType(VARCHAR), Length(255,true), Default(None) */
    val pre: Rep[Option[String]] = column[Option[String]]("pre", O.Length(255,varying=true), O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P4Parents */
  lazy val P4Parents = new TableQuery(tag => new P4Parents(tag))

  /** Entity class storing rows of table P5UseImgs
   *  @param title Database column title SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param memo Database column memo SqlType(TEXT), Default(None)
   *  @param image1 Database column image1 SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param image2 Database column image2 SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param gcs Database column gcs SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P5UseImgsRow(title: Option[String] = None, memo: Option[String] = None, image1: Option[String] = None, image2: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, gcs: Option[String] = None, id: Option[Int] = None)
  /** GetResult implicit for fetching P5UseImgsRow objects using plain SQL queries */
  implicit def GetResultP5UseImgsRow(implicit e0: GR[Option[String]], e1: GR[java.sql.Timestamp], e2: GR[Option[Int]]): GR[P5UseImgsRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[String])
    import r._
    P5UseImgsRow.tupled((_2, _3, _4, _5, _6, _7, _8, _1)) // putting AutoInc last
  }
  /** Table description of table p5_use_imgs. Objects of this class serve as prototypes for rows in queries. */
  class P5UseImgs(_tableTag: Tag) extends Table[P5UseImgsRow](_tableTag, "p5_use_imgs") {
    def * = (title, memo, image1, image2, createdAt, updatedAt, gcs, Rep.Some(id)) <> (P5UseImgsRow.tupled, P5UseImgsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (title, memo, image1, image2, Rep.Some(createdAt), Rep.Some(updatedAt), gcs, Rep.Some(id)).shaped.<>({r=>import r._; _5.map(_=> P5UseImgsRow.tupled((_1, _2, _3, _4, _5.get, _6.get, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column title SqlType(VARCHAR), Length(255,true), Default(None) */
    val title: Rep[Option[String]] = column[Option[String]]("title", O.Length(255,varying=true), O.Default(None))
    /** Database column memo SqlType(TEXT), Default(None) */
    val memo: Rep[Option[String]] = column[Option[String]]("memo", O.Default(None))
    /** Database column image1 SqlType(VARCHAR), Length(255,true), Default(None) */
    val image1: Rep[Option[String]] = column[Option[String]]("image1", O.Length(255,varying=true), O.Default(None))
    /** Database column image2 SqlType(VARCHAR), Length(255,true), Default(None) */
    val image2: Rep[Option[String]] = column[Option[String]]("image2", O.Length(255,varying=true), O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column gcs SqlType(VARCHAR), Length(255,true), Default(None) */
    val gcs: Rep[Option[String]] = column[Option[String]]("gcs", O.Length(255,varying=true), O.Default(None))
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P5UseImgs */
  lazy val P5UseImgs = new TableQuery(tag => new P5UseImgs(tag))

  /** Entity class storing rows of table P6Groups
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param description Database column description SqlType(TEXT), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P6GroupsRow(name: Option[String] = None, description: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching P6GroupsRow objects using plain SQL queries */
  implicit def GetResultP6GroupsRow(implicit e0: GR[Option[String]], e1: GR[java.sql.Timestamp], e2: GR[Option[Int]]): GR[P6GroupsRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    P6GroupsRow.tupled((_2, _3, _4, _5, _1)) // putting AutoInc last
  }
  /** Table description of table p6_groups. Objects of this class serve as prototypes for rows in queries. */
  class P6Groups(_tableTag: Tag) extends Table[P6GroupsRow](_tableTag, "p6_groups") {
    def * = (name, description, createdAt, updatedAt, Rep.Some(id)) <> (P6GroupsRow.tupled, P6GroupsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (name, description, Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _3.map(_=> P6GroupsRow.tupled((_1, _2, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column description SqlType(TEXT), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P6Groups */
  lazy val P6Groups = new TableQuery(tag => new P6Groups(tag))

  /** Entity class storing rows of table P6GroupsUsers
   *  @param p6GroupId Database column p6_group_id SqlType(INT)
   *  @param p6UserId Database column p6_user_id SqlType(INT) */
  case class P6GroupsUsersRow(p6GroupId: Int, p6UserId: Int)
  /** GetResult implicit for fetching P6GroupsUsersRow objects using plain SQL queries */
  implicit def GetResultP6GroupsUsersRow(implicit e0: GR[Int]): GR[P6GroupsUsersRow] = GR{
    prs => import prs._
    val r = (<<[Int], <<[Int])
    import r._
    P6GroupsUsersRow.tupled((_1, _2)) // putting AutoInc last
  }
  /** Table description of table p6_groups_users. Objects of this class serve as prototypes for rows in queries. */
  class P6GroupsUsers(_tableTag: Tag) extends Table[P6GroupsUsersRow](_tableTag, "p6_groups_users") {
    def * = (p6GroupId, p6UserId) <> (P6GroupsUsersRow.tupled, P6GroupsUsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(p6GroupId), Rep.Some(p6UserId)).shaped.<>({r=>import r._; _1.map(_=> P6GroupsUsersRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column p6_group_id SqlType(INT) */
    val p6GroupId: Rep[Int] = column[Int]("p6_group_id")
    /** Database column p6_user_id SqlType(INT) */
    val p6UserId: Rep[Int] = column[Int]("p6_user_id")

    /** Index over (p6GroupId) (database name index_p6_groups_users_on_p6_group_id) */
    val index1 = index("index_p6_groups_users_on_p6_group_id", p6GroupId)
    /** Index over (p6UserId) (database name index_p6_groups_users_on_p6_user_id) */
    val index2 = index("index_p6_groups_users_on_p6_user_id", p6UserId)
  }
  /** Collection-like TableQuery object for table P6GroupsUsers */
  lazy val P6GroupsUsers = new TableQuery(tag => new P6GroupsUsers(tag))

  /** Entity class storing rows of table P6Users
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param email Database column email SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P6UsersRow(name: Option[String] = None, email: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching P6UsersRow objects using plain SQL queries */
  implicit def GetResultP6UsersRow(implicit e0: GR[Option[String]], e1: GR[java.sql.Timestamp], e2: GR[Option[Int]]): GR[P6UsersRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    P6UsersRow.tupled((_2, _3, _4, _5, _1)) // putting AutoInc last
  }
  /** Table description of table p6_users. Objects of this class serve as prototypes for rows in queries. */
  class P6Users(_tableTag: Tag) extends Table[P6UsersRow](_tableTag, "p6_users") {
    def * = (name, email, createdAt, updatedAt, Rep.Some(id)) <> (P6UsersRow.tupled, P6UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (name, email, Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _3.map(_=> P6UsersRow.tupled((_1, _2, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column email SqlType(VARCHAR), Length(255,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true), O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P6Users */
  lazy val P6Users = new TableQuery(tag => new P6Users(tag))

  /** Entity class storing rows of table P7Scaffolds
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param email Database column email SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param birthday Database column birthday SqlType(DATE), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P7ScaffoldsRow(name: Option[String] = None, email: Option[String] = None, birthday: Option[java.sql.Date] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching P7ScaffoldsRow objects using plain SQL queries */
  implicit def GetResultP7ScaffoldsRow(implicit e0: GR[Option[String]], e1: GR[Option[java.sql.Date]], e2: GR[java.sql.Timestamp], e3: GR[Option[Int]]): GR[P7ScaffoldsRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[String], <<?[java.sql.Date], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    P7ScaffoldsRow.tupled((_2, _3, _4, _5, _6, _1)) // putting AutoInc last
  }
  /** Table description of table p7_scaffolds. Objects of this class serve as prototypes for rows in queries. */
  class P7Scaffolds(_tableTag: Tag) extends Table[P7ScaffoldsRow](_tableTag, "p7_scaffolds") {
    def * = (name, email, birthday, createdAt, updatedAt, Rep.Some(id)) <> (P7ScaffoldsRow.tupled, P7ScaffoldsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (name, email, birthday, Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _4.map(_=> P7ScaffoldsRow.tupled((_1, _2, _3, _4.get, _5.get, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column email SqlType(VARCHAR), Length(255,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true), O.Default(None))
    /** Database column birthday SqlType(DATE), Default(None) */
    val birthday: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("birthday", O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P7Scaffolds */
  lazy val P7Scaffolds = new TableQuery(tag => new P7Scaffolds(tag))

  /** Entity class storing rows of table P8Hellos
   *  @param name Database column name SqlType(VARCHAR), Length(30,true), Default(None)
   *  @param birthday Database column birthday SqlType(DATE), Default(None)
   *  @param memo Database column memo SqlType(TEXT), Default(None)
   *  @param address Database column address SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P8HellosRow(name: Option[String] = None, birthday: Option[java.sql.Date] = None, memo: Option[String] = None, address: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching P8HellosRow objects using plain SQL queries */
  implicit def GetResultP8HellosRow(implicit e0: GR[Option[String]], e1: GR[Option[java.sql.Date]], e2: GR[java.sql.Timestamp], e3: GR[Option[Int]]): GR[P8HellosRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[java.sql.Date], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    P8HellosRow.tupled((_2, _3, _4, _5, _6, _7, _1)) // putting AutoInc last
  }
  /** Table description of table p8_hellos. Objects of this class serve as prototypes for rows in queries. */
  class P8Hellos(_tableTag: Tag) extends Table[P8HellosRow](_tableTag, "p8_hellos") {
    def * = (name, birthday, memo, address, createdAt, updatedAt, Rep.Some(id)) <> (P8HellosRow.tupled, P8HellosRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (name, birthday, memo, address, Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _5.map(_=> P8HellosRow.tupled((_1, _2, _3, _4, _5.get, _6.get, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(VARCHAR), Length(30,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(30,varying=true), O.Default(None))
    /** Database column birthday SqlType(DATE), Default(None) */
    val birthday: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("birthday", O.Default(None))
    /** Database column memo SqlType(TEXT), Default(None) */
    val memo: Rep[Option[String]] = column[Option[String]]("memo", O.Default(None))
    /** Database column address SqlType(VARCHAR), Length(100,true), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Length(100,varying=true), O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table P8Hellos */
  lazy val P8Hellos = new TableQuery(tag => new P8Hellos(tag))

  /** Entity class storing rows of table P9Hellos
   *  @param name Database column name SqlType(VARCHAR), Length(30,true), Default(None)
   *  @param birthday Database column birthday SqlType(DATE), Default(None)
   *  @param memo Database column memo SqlType(TEXT), Default(None)
   *  @param address Database column address SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME)
   *  @param updatedAt Database column updated_at SqlType(DATETIME)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class P9HellosRow(name: Option[String] = None, birthday: Option[java.sql.Date] = None, memo: Option[String] = None, address: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, id: Option[Int] = None)
  /** GetResult implicit for fetching P9HellosRow objects using plain SQL queries */
  implicit def GetResultP9HellosRow(implicit e0: GR[Option[String]], e1: GR[Option[java.sql.Date]], e2: GR[java.sql.Timestamp], e3: GR[Option[Int]]): GR[P9HellosRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[java.sql.Date], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp])
    import r._
    P9HellosRow.tupled((_2, _3, _4, _5, _6, _7, _1)) // putting AutoInc last
  }
  /** Table description of table p9_hellos. Objects of this class serve as prototypes for rows in queries. */
  class P9Hellos(_tableTag: Tag) extends Table[P9HellosRow](_tableTag, "p9_hellos") {
    def * = (name, birthday, memo, address, createdAt, updatedAt, Rep.Some(id)) <> (P9HellosRow.tupled, P9HellosRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (name, birthday, memo, address, Rep.Some(createdAt), Rep.Some(updatedAt), Rep.Some(id)).shaped.<>({r=>import r._; _5.map(_=> P9HellosRow.tupled((_1, _2, _3, _4, _5.get, _6.get, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(VARCHAR), Length(30,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(30,varying=true), O.Default(None))
    /** Database column birthday SqlType(DATE), Default(None) */
    val birthday: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("birthday", O.Default(None))
    /** Database column memo SqlType(TEXT), Default(None) */
    val memo: Rep[Option[String]] = column[Option[String]]("memo", O.Default(None))
    /** Database column address SqlType(VARCHAR), Length(100,true), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Length(100,varying=true), O.Default(None))
    /** Database column created_at SqlType(DATETIME) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(DATETIME) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)

    /** Uniqueness Index over (name) (database name index_p9_hellos_on_name) */
    val index1 = index("index_p9_hellos_on_name", name, unique=true)
  }
  /** Collection-like TableQuery object for table P9Hellos */
  lazy val P9Hellos = new TableQuery(tag => new P9Hellos(tag))

  /** Entity class storing rows of table Roles
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param resourceType Database column resource_type SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param resourceId Database column resource_id SqlType(INT), Default(None)
   *  @param createdAt Database column created_at SqlType(DATETIME), Default(None)
   *  @param updatedAt Database column updated_at SqlType(DATETIME), Default(None)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class RolesRow(name: Option[String] = None, resourceType: Option[String] = None, resourceId: Option[Int] = None, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None, id: Option[Int] = None)
  /** GetResult implicit for fetching RolesRow objects using plain SQL queries */
  implicit def GetResultRolesRow(implicit e0: GR[Option[String]], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]]): GR[RolesRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<?[String], <<?[String], <<?[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp])
    import r._
    RolesRow.tupled((_2, _3, _4, _5, _6, _1)) // putting AutoInc last
  }
  /** Table description of table roles. Objects of this class serve as prototypes for rows in queries. */
  class Roles(_tableTag: Tag) extends Table[RolesRow](_tableTag, "roles") {
    def * = (name, resourceType, resourceId, createdAt, updatedAt, Rep.Some(id)) <> (RolesRow.tupled, RolesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (name, resourceType, resourceId, createdAt, updatedAt, Rep.Some(id)).shaped.<>({r=>import r._; _6.map(_=> RolesRow.tupled((_1, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column resource_type SqlType(VARCHAR), Length(255,true), Default(None) */
    val resourceType: Rep[Option[String]] = column[Option[String]]("resource_type", O.Length(255,varying=true), O.Default(None))
    /** Database column resource_id SqlType(INT), Default(None) */
    val resourceId: Rep[Option[Int]] = column[Option[Int]]("resource_id", O.Default(None))
    /** Database column created_at SqlType(DATETIME), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(DATETIME), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)

    /** Index over (name) (database name index_roles_on_name) */
    val index1 = index("index_roles_on_name", name)
    /** Index over (name,resourceType,resourceId) (database name index_roles_on_name_and_resource_type_and_resource_id) */
    val index2 = index("index_roles_on_name_and_resource_type_and_resource_id", (name, resourceType, resourceId))
  }
  /** Collection-like TableQuery object for table Roles */
  lazy val Roles = new TableQuery(tag => new Roles(tag))

  /** Entity class storing rows of table SchemaMigrations
   *  @param version Database column version SqlType(VARCHAR), PrimaryKey, Length(255,true) */
  case class SchemaMigrationsRow(version: String)
  /** GetResult implicit for fetching SchemaMigrationsRow objects using plain SQL queries */
  implicit def GetResultSchemaMigrationsRow(implicit e0: GR[String]): GR[SchemaMigrationsRow] = GR{
    prs => import prs._
    SchemaMigrationsRow(<<[String])
  }
  /** Table description of table schema_migrations. Objects of this class serve as prototypes for rows in queries. */
  class SchemaMigrations(_tableTag: Tag) extends Table[SchemaMigrationsRow](_tableTag, "schema_migrations") {
    def * = version <> (SchemaMigrationsRow, SchemaMigrationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = Rep.Some(version).shaped.<>(r => r.map(_=> SchemaMigrationsRow(r.get)), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column version SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val version: Rep[String] = column[String]("version", O.PrimaryKey, O.Length(255,varying=true))
  }
  /** Collection-like TableQuery object for table SchemaMigrations */
  lazy val SchemaMigrations = new TableQuery(tag => new SchemaMigrations(tag))
}

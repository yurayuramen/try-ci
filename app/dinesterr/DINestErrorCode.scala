package dinesterr

import javax.inject.Singleton
import com.google.inject.ImplementedBy
import javax.inject.Inject

class DINestErrorCode {
  
}

@ImplementedBy(classOf[Code01Impl])
trait Code01
{
  def hello():String
}

@Singleton
class Code01Impl extends Code01
{
  def hello()="code01"
}

@ImplementedBy(classOf[Code02Impl])
trait Code02
{
  def hello():String
}

@Singleton
class Code02Impl @Inject()(code01:Code01) extends Code02
{
  def hello()="code02"
}

@ImplementedBy(classOf[Code03Impl])
trait Code03
{
  def hello():String
}

@Singleton
class Code03Impl @Inject()(code04:Code04)  extends Code03
{
  def hello()="code01"
}

@ImplementedBy(classOf[Code04Impl])
trait Code04
{
  def hello():String
}

@Singleton
class Code04Impl @Inject()(code03:Code03) extends Code04
{
  def hello()="code02"
}


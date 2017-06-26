package org.pactDemo.ios

import com.twitter.finatra.http.Controller
import com.twitter.finatra.request.RouteParam
import org.pactDemo.utilities.{FinatraClient, FinatraServer}

case class IosRequest(@RouteParam id: Int)


class IosAppController extends Controller {
  val client = new FinatraClient("localhost", 9000, _.replace("}", ""","server":"ios"}"""))
  get("/id/:id") { request: IosRequest =>
    client(request.id).map(response.ok(_).contentType("application/json"))
  }
}

object IosApp extends App {
  new FinatraServer(9020, new IosAppController).main(Array())
}

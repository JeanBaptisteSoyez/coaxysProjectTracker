using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CoaxysProjectTracker.Controllers
{
    public class EpicController : Controller
    {
        // GET: Epic
        public ActionResult Index()
        {
            return View();
        }
    }
}
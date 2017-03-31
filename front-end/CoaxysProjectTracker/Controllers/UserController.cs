using CoaxysProjectTracker.Api;
using CoaxysProjectTracker.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;

namespace CoaxysProjectTracker.Controllers
{
    public class UserController : Controller
    {
        public async Task<ActionResult> Index()
        {
            return View("Index",
                await API.GetAsync<List<User>>("user.json")
            );
        }
    }
}
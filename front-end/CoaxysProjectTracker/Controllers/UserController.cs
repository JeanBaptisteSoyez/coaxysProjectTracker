using CoaxysProjectTracker.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using CoaxysProjectTracker.Models;

namespace CoaxysProjectTracker.Controllers
{
    public class UserController : Controller
    {
        public async Task<ActionResult> Index()
        {
            return View("Index",
                await Api.GetAsync<List<User>>("user.json")
            );
        }
    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using CoaxysProjectTracker.Models;
using CoaxysProjectTracker.Services;

namespace CoaxysProjectTracker.Controllers
{
    public class StatusController : Controller
    {
        // GET: Status
 
            public async Task<ActionResult> Index()
            {
                var status = await Api.GetAsync<List<Status>>("status.json");
                return View(status);
            
            }

        public ActionResult  Update(int id)
        {
            
            return View();
        }
    }
}
using CoaxysProjectTracker.Services;
using CoaxysProjectTracker.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;

namespace CoaxysProjectTracker.Controllers
{
    public class EpicController : Controller
    {
        // affichage des epics
            public async Task<ActionResult> Index()
            {
                var epics = await Api.GetAsync<List<Epic>>("epic.json");
                return View(epics);
            }

    }

}

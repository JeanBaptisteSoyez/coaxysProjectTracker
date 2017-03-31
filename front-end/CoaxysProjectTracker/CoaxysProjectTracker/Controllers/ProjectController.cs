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
    public class ProjectController : Controller
    {
        public async Task<ActionResult> Index()
        {
            var projects = await API.GetAsync<List<Project>>("project.json");
            return View(projects);
        }
    }
}
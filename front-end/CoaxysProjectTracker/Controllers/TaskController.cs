using CoaxysProjectTracker.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;


namespace CoaxysProjectTracker.Controllers
{
    public class TaskController : Controller
    {
        // GET: Task
        public async Task<ActionResult> Index()
        {
            var tasks = await Api.GetAsync<List<Models.Task>>("task.json");
            return View(tasks);
        }
    }
}
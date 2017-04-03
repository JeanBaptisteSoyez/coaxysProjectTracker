using CoaxysProjectTracker.Api;
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
            var tasks = await API.GetAsync<List<Entities.Task>>("task.json");
            return View(tasks);
        }

        public ActionResult Create()
        {
            return View();
        }
        public ActionResult Edit()
        {
            return View();
        }
    }
}
using CoaxysProjectTracker.Attributes;
using CoaxysProjectTracker.Services;
using CoaxysProjectTracker.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;


namespace CoaxysProjectTracker.Controllers
{
    [CustomAuthorize]
    public class TaskController : Controller
    {
        protected TaskRepository repository;

        // GET: Task
        public async Task<ActionResult> Index()
        {
            var tasks = await Api.GetAsync<List<Models.Task>>("task.json");
            return View(tasks);
        }

        public ActionResult Create()
        {
            return View();
        }


        public async Task<ActionResult> Edit(int id)
        {
            var task = await repository.GetTaskByID(id);
            return View(task);
        }

        public ActionResult Details()
        { return View(); }

        public async Task<ActionResult> ListAllTasksAsync()
        {
            var tasks = await Api.GetAsync<List<Task>>("task.json");
            return View(tasks);
        }
    }
}
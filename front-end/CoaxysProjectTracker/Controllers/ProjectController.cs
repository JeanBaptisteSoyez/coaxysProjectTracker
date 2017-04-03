using CoaxysProjectTracker.Repositories;
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
        protected ProjectRepository repository;

        public ProjectController()
        {
            repository = new ProjectRepository();
        }

        public async Task<ActionResult> Index()
        {
            var projects = await repository.GetProjects();
            return View(projects);
        }
    }
}
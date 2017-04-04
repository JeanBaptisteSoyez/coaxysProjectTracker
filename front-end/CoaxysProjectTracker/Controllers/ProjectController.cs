using CoaxysProjectTracker.Attributes;
using CoaxysProjectTracker.Extensions;
using CoaxysProjectTracker.Models;
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

        public ActionResult Create()
        {
            return PartialView();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(Project project)
        {
            Project resultProject = await repository.InsertProject(project);

            if (resultProject != null)
            {
                TempData.AddMessage((int)TempDataMessageType.Success, "Le projet a bien été créé.");
            }
            else
            {
                TempData.AddMessage((int)TempDataMessageType.Danger, "Un problème est survenu. Le projet n'a pas été créé.");
            }

            return RedirectToAction("index");
        }

        public async Task<ActionResult> Edit(int id)
        {
            var project = await repository.GetProjectByID(id);
            return PartialView(project);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit(Project project)
        {
            Project resultProject = await repository.UpdateProject(project);

            if (resultProject != null)
            {
                TempData.AddMessage((int)TempDataMessageType.Success, "Le projet a bien été mis à jour.");
            }
            else
            {
                TempData.AddMessage((int)TempDataMessageType.Danger, "Un problème est survenu. Le projet n'a pas été mis à jour.");
            }

            return RedirectToAction("index");
        }

    }
}
using CoaxysProjectTracker.Services;
using CoaxysProjectTracker.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using CoaxysProjectTracker.Attributes;
using CoaxysProjectTracker.Repositories;
using CoaxysProjectTracker.Extensions;

namespace CoaxysProjectTracker.Controllers
{
    [CustomAuthorize]
    public class EpicController : Controller
    {
        protected EpicRepository repository;

        public EpicController()
        {
            repository = new EpicRepository();
        }
        
        public async Task<ActionResult> Index()
        {
            var epics = await repository.GetEpics();
            return View(epics);
        }

        public ActionResult Create()
        {
            return PartialView();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(Epic epic)
        {
            Epic resultEpic = await repository.InsertEpic(epic);

            if (resultEpic != null)
            {
                TempData.AddMessage((int)TempDataMessageType.Success, "L'epic a bien été créée.");
            }
            else
            {
                TempData.AddMessage((int)TempDataMessageType.Danger, "Un problème est survenu. L'epic n'a pas été créée.");
            }

            return RedirectToAction("index");
        }

        public async Task<ActionResult> Edit(int id)
        {
            var epic = await repository.GetEpicByID(id);
            return PartialView(epic);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit(Epic epic)
        {
            Epic resultEpic = await repository.UpdateEpic(epic);

            if (resultEpic != null)
            {
                TempData.AddMessage((int)TempDataMessageType.Success, "L'epic a bien été mise à jour.");
            }
            else
            {
                TempData.AddMessage((int)TempDataMessageType.Danger, "Un problème est survenu. L'epic n'a pas été mise à jour.");
            }

            return RedirectToAction("index");
        }

    }

}
